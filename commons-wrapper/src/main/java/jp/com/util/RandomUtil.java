/**
 * 
 */
package jp.com.util;

import java.util.UUID;

/**
 * �����_�����[�e�B���e�B�N���X
 *
 */
public class RandomUtil {

	/**
	 * �����_����UUID�𐶐�����
	 * <br>
	 * @erturn 128�r�b�g�̃��j�[�N�Ȓl
	 */
	public static String getStringUUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * �C�ӂ̃����_���ϐ����擾
	 * @return double
	 */
	public static double getRandom() {
		return Math.random();
	}
	
	
}
