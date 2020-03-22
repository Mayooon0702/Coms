/**
 * 
 */
package jp.com.util;

import java.util.UUID;

/**
 * ランダムユーティリティクラス
 *
 */
public class RandomUtil {

	/**
	 * ランダムなUUIDを生成する
	 * <br>
	 * @erturn 128ビットのユニークな値
	 */
	public static String getStringUUID() {
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 任意のランダム変数を取得
	 * @return double
	 */
	public static double getRandom() {
		return Math.random();
	}
	
	
}
