package jp.com.encript;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class EncrypterTest {
    
    private Encrypter encrypter = null;
    
    @Test
    public void testEncripter() {
    	// SecretKeyAInitializationVector‚Í­‚È‚­‚Æ‚à16byte•K—v
    	encrypter = new Encrypter("testKey890123456","initialVector456");
    	assertThat((encrypter instanceof Encrypter),is(true));
    }

    @Test
    public void testEncrypt() {
    	encrypter = new Encrypter("testKey890123456","initialVector456");
    	String originStr = "Aa1!#$%";
    	String encryptedStr = encrypter.encrypt(originStr);
    	String decryptedStr = encrypter.decrypt(encryptedStr);
    	System.out.println(String.join("->", originStr,encryptedStr,decryptedStr));
    	assertThat(decryptedStr,is(originStr));
    }

    @Test
    public void testDecrypt() {
    	encrypter = new Encrypter("testKey890123456","initialVector456");
    	String originStr = "1234567890(^^)";
    	String encryptedStr = encrypter.encrypt(originStr);
    	String decryptedStr = encrypter.decrypt(encryptedStr);
    	System.out.println(String.join("->", originStr,encryptedStr,decryptedStr));
    	assertThat(decryptedStr,is(originStr));
    }

}
