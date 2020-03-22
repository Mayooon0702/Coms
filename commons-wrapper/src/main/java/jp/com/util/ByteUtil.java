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
	 * コンストラクタ
	 */
	public ByteUtil(byte[] bytes){
		mBytes = bytes;
	}

	/**
	 * バイナリ配列内サーチメソッド
	 * @param bytes
	 * @return
	 */
	public int indexOf(byte[] bytes){
		return indexOf(bytes,0);
	}

	/**
	 * バイナリ配列内サーチメソッド
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
	 * 配列内の引数の数のカウントメソッド
	 * @param bytesArg
	 * @return 配列内の引数値の数
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
	 * バイナリ連結メソッド
	 * @param bytes
	 * @return 連結後の文字列
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
	//TODO replaceメソッド
	//TODO バイナリ → 16進文字列変換

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
