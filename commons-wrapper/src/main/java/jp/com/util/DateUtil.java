/**
 * DatetimeUtilクラス 
 */
package jp.com.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


/**
 * 日付ユーティリティ
 */
public class DateUtil {
	
	private static String YYYY = "((19|2[0-9])[0-9]{2})";
	private static String MM = "(0[1-9]|1[012])";
	private static String DD = "(0[1-9]|[12][0-9]|3[01])";
	
	private static String[] DATE_PATTERNS = {
		"^" + YYYY + MM + DD +"$",
		"^" + YYYY + "-" + MM + "-" + DD +"$",
		"^" + YYYY + "/" + MM + "/" + DD +"$",
		"^" + YYYY + "." + MM + "." + DD +"$"
	};
		
	private static String[] DATE_FORMATS = {
			"yyyyMMdd",
			"yyyy-MM-dd",
			"yyyy/MM/dd",
			"yyyy.MM.dd"
	};
	
	/**
	 * 日付文字列LocalDate変換
	 * @param dateStr
	 * @return
	 */
    public static LocalDate convert(String date) {
    	LocalDate localDate = null;
    	try {
	    	for(int i=0; i <DATE_PATTERNS.length; i++ ) {
	    		if(Pattern.compile(DATE_PATTERNS[i]).matcher(date).matches()) {
	    			localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMATS[i]));
	    		}
	    	}
	    	return localDate;
    	}catch(Exception e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /**
     * LocalDate文字列変換(yyyyMMdd)
     * @param localDate
     * @return String(yyyyMMdd)
     */
    public static String convert(LocalDate localDate) {
    	return convert("yyyyMMdd",localDate);
    }
    
    /**
     * LocalDate文字列変換(yyyy/MM/dd)
     * @param localDate
     * @return String(yyyy/MM/dd)
     */
    public static String convertLog(LocalDate localDate){
    	return convert("yyyy/MM/dd",localDate);
    }

    /**
     * LocalDate文字列変換(yyyy-MM-dd)
     * @param localDate LocalDate
     * @return String(yyyy-MM-dd)
     */
    public static String convertDb(LocalDate localDate){
    	return convert("yyyy-MM-dd",localDate);
    }
    
    /**
     * LocalDate文字列変換(yyyy.MM.dd)
     * @param localDate LocalDate
     * @return String(yyyy.MM.dd)
     */
    public static String convertSimple(LocalDate localDate) {
    	return convert("yyyy.MM.dd",localDate);
    }
    
    /**
     * 日付文字列メソッド
     * @param format フォーマット
     * @param localDate LocalDate
     * @return String(format)
     */
    public static String convert(String format, LocalDate localDate) {
    	return DateTimeFormatter.ofPattern(format).format(localDate);
    }

    //TODO Date型も追加
    
}
