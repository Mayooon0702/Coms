/**
 * 
 */
package jp.com.encript;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 暗号化/復号化
 */
public class Encrypter {

    // モード
    private static final String MODE = "AES";
    
    // アルゴリズム/ブロックモード/パディング方式
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    
    // 暗号化＆復号化で使用する鍵
    private String encryptKey;
    
    // 初期ベクトル
    private String initialVector;
    
    private Encrypter() {}
    
    public Encrypter(String encryptKey, String initialVector) {
	this.encryptKey = encryptKey;
	this.initialVector = initialVector;
    }
    

    /**
     * 暗号化
     * @param token トークン
     * @return String
     */
    public String encrypt(String token){
	try {
	    IvParameterSpec iv = new IvParameterSpec(initialVector.getBytes());
	    SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), MODE);
	    Cipher encrypter = Cipher.getInstance(ALGORITHM);
	    encrypter.init(Cipher.ENCRYPT_MODE, key, iv);
	    byte[] byteToken = encrypter.doFinal(token.getBytes());
	    return new String(Base64.getEncoder().encode(byteToken));
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }


    /**
     * 復号化
     * @param token トークン
     * @return String
     */
    public String decrypt(String encryptedToken) {

	try {
	    IvParameterSpec iv = new IvParameterSpec(initialVector.getBytes());
	    SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), MODE);
	    Cipher decrypter = Cipher.getInstance(ALGORITHM);
	    decrypter.init(Cipher.DECRYPT_MODE, key, iv);
	    byte[] byteToken = Base64.getDecoder().decode(encryptedToken);
	    return new String(decrypter.doFinal(byteToken));
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }
}
