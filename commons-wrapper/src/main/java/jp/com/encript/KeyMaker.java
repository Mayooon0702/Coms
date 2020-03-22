/**
 * 
 */
package jp.com.encript;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Key�쐬
 */
public class KeyMaker {

    private static final String ERR_MSG_SHORT_ID= "invalid Elm(Short Login Id)";
    
    
    /**
     * �L�[����
     * <pre>
     * ��̈�������A�K�������v�f�̃L�[������𐶐�����
     * </pre>
     * @param elem �C�ӂ̕�����(8byte)
     * @param strDateTime ����������(yyyy-MM-dd HH:mm:ss)
     * @return 16byte�ȏ�̃L�[�𐶐�
     */
    public static String create(String elem, String strDateTime) {
    	String transElem = transHex16(elem);
    	strDateTime = strDateTime.replaceAll("-", "").replaceAll(":","").replaceAll(" ", "");
    	String returnElm =
          transElem.substring(0,4) 
          + strDateTime.substring(0,6)
          + transElem.substring(4,8)
          + strDateTime.substring(6,10)
          + transElem.substring(8,12)
          + strDateTime.substring(10,14)
          + transElem.substring(12,16);
    	return returnElm;
    }
    
    /**
     * SHA-256�n�b�V���ό`��
     * @param elm ������
     * @return �ό`SHA-256
     */
    public static String create256(String elm) {
      String sha256 = DigestUtils.sha256Hex(elm);
      return sha256.substring(16,32) + sha256.substring(48,64)+ sha256.substring(32,48) + sha256.substring(0,16); 
    }
    
    /**
     * 16byte���l�ϊ�
     * @param word ����
     * @return
     */
    private static String transHex16(String word) {
    	if(word.getBytes().length < 8) {
    	    throw new RuntimeException(ERR_MSG_SHORT_ID);
    	}
    	// �擪����16byte�𔲂��o��
    	return (new String(Hex.encodeHex(word.getBytes()))).substring(0,16);
    }
    
    
}
