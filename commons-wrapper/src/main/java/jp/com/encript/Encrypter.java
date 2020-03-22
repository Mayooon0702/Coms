/**
 * 
 */
package jp.com.encript;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * �Í���/������
 */
public class Encrypter {

    // ���[�h
    private static final String MODE = "AES";
    
    // �A���S���Y��/�u���b�N���[�h/�p�f�B���O����
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    
    // �Í������������Ŏg�p���錮
    private String encryptKey;
    
    // �����x�N�g��
    private String initialVector;
    
    /**
     * new�}�~
     */
    @SuppressWarnings("unused")
    private Encrypter() {}
    
    public Encrypter(String encryptKey, String initialVector) {
        this.encryptKey = encryptKey;
        this.initialVector = initialVector;
    }
    
    /**
     * �Í���
     * @param token �g�[�N��
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
     * ������
     * @param token �g�[�N��
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
