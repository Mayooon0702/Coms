/**
 * 
 */
package jp.com.util;

/**
 *
 */
public class ByteUtil {
	private final byte[] mBytes;

	/**
	 * �R���X�g���N�^
	 */
	public ByteUtil(byte[] bytes){
		mBytes = bytes;
	}

	/**
	 * �o�C�i���z����T�[�`���\�b�h
	 * @param bytes
	 * @return
	 */
	public int indexOf(byte[] bytes){
		return indexOf(bytes,0);
	}

	/**
	 * �o�C�i���z����T�[�`���\�b�h
	 * @param bytes
	 * @param startIndex
	 * @return
	 */
	public int indexOf(byte[] bytes, int startIndex){
		boolean isSearched = false;
		int index = -1;

		if (bytes == null || bytes.length == 0) {
			return -1;
		}
		if ( mBytes.length - startIndex <= bytes.length ) {
			return -1;
		}
		if (startIndex > mBytes.length || startIndex < 0) {
			return -1;
		}

		for(int i = startIndex; i < mBytes.length; i++){
			for(int j = 0; j < bytes.length; j++){
				if ( mBytes[i + j] == bytes[j] ) {
					if( j == bytes.length - 1){
						isSearched = true;
					}
				}else{
					break;
				}
			}
			if (isSearched) {
				index = i;
				break;
			}
		}
		return index;

	}

	/**
	 * �z����̈����̐��̃J�E���g���\�b�h
	 * @param bytesArg
	 * @return �z����̈����l�̐�
	 */
	public int countOf(byte[] bytes){
		int count = 0;
		boolean isSearched = false;

		if (bytes == null || bytes.length == 0) {
			return 0;
		}
		for(int i = 0; i < mBytes.length; i++){
			for(int j = 0; j < bytes.length; j++){
				if ( mBytes[i + j] == bytes[j] ) {
					if( j == bytes.length - 1){
						isSearched = true;
					}
				}else{
					break;
				}
			}
			if (isSearched) {
				count = count + 1;
				i = i + bytes.length;
				isSearched = false;
			}
		}
		return count;
	}

	/**
	 * �o�C�i���A�����\�b�h
	 * @param bytes
	 * @return �A����̕�����
	 */
	public byte[] concat(byte[] bytes){

		if (bytes == null || bytes.length == 0) {
			return mBytes;
		}

		byte[] outBytes = new byte[mBytes.length + bytes.length];
		for (int i = 0, j = 0; i < outBytes.length; i++) {
			if( i < mBytes.length ){
				outBytes[i] = mBytes[i];
			}else{
				outBytes[i] = bytes[j];
				j++;
			}
		}
		return outBytes;

	}
	//TODO replace���\�b�h
	//TODO �o�C�i�� �� 16�i������ϊ�

	/**
	 *
	 * @param bytesBef
	 * @param bytesAft
	 * @return
	 */
	public byte[] replace(byte[] bytesBef, byte[] bytesAft) {
		byte[] a = null;
		return a;
	}


}
