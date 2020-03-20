/**
 * 
 */
package jp.com.password;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * �p�X���[�h�쐬�N���X
 *
 */
public class PasswdUtil {
	protected static final String CANDIDATE1 = "abcdefghijklmnopqrstuvwxyz";
	protected static final String CANDIDATE2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	protected static final String CANDIDATE3 = "0123456789";
	protected static final String CANDIDATE4 = "!@";

	
	/**
	 * �p�X���[�h�V�K�쐬
	 * @return 8byte ������
	 */
	public static String createNew8() {
		return create(8);
	}
	
	
	
	
	/**
	 * �V���Ƀp�X���[�h�𕥂��o��
	 * @return String
	 */
	private static String create(int keta) {
		
		char[] generated = new char[keta];
		String candidateAll = "";
		int watermark = 0;
		String[] candidates = new String[] {
			CANDIDATE1,
			CANDIDATE2,
			CANDIDATE3,
			CANDIDATE4
		};
		int max = candidates.length;
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	 
			if (keta < candidates.length) {
				max = keta;
			}
			// ���ꂼ��̃p�[�g����Œ�1������I������.
			for (int i = 0; i < max; i++) {
				if (candidates[i] != null && !"".equals(candidates[i])) {
					generated[watermark++] = candidates[i]
						.charAt(sr.nextInt(candidates[i].length()));
					candidateAll += candidates[i];
				}
			}
	 
			// ���ׂẴp�[�g����c��̕��������肷��.
			for (int i = watermark; i < keta; i++) {
				generated[i] = candidateAll
					.charAt(sr.nextInt(candidateAll.length()));
			}
	 
			// ���ȏ�܂���
			for (int i = 100000; i >= 0; i--) {
				int x = sr.nextInt(keta);
				int y = sr.nextInt(keta);
				char tmp = generated[x];
				generated[x] = generated[y];
				generated[y] = tmp;
			}
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return new String(generated);
		
	}
}
