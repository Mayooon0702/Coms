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
    
    /**
     * new抑止
     */
    @SuppressWarnings("unused")
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
    	    Cipher ciper = Cipher.getInstance(ALGORITHM);
    	    ciper.init(Cipher.ENCRYPT_MODE, 
    		    new SecretKeySpec(encryptKey.getBytes(), MODE), 
    		    new IvParameterSpec(initialVector.getBytes()));
    	    return new String(Base64.getEncoder().encode(ciper.doFinal(token.getBytes())));
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
    	    Cipher ciper = Cipher.getInstance(ALGORITHM);
    	    ciper.init(Cipher.DECRYPT_MODE, 
    		    new SecretKeySpec(encryptKey.getBytes(), MODE), 
    		    new IvParameterSpec(initialVector.getBytes()));
    	    return new String(ciper.doFinal(Base64.getDecoder().decode(encryptedToken)));
    	} catch (Exception e) {
    	    throw new RuntimeException(e);
    	}
    }
}
