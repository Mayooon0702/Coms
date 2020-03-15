/**
 * DatetimeUtil�N���X 
 */
package jp.com.datetime;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Pattern;


/**
 *
 */
public class DateTimeUtil {
	
	private static String YYYY = "((19|2[0-9])[0-9]{2})";
	private static String MM = "(0[1-9]|1[012])";
	private static String DD = "(0[1-9]|[12][0-9]|3[01])";
	private static String HH = "(0[0-9]|1[0-2]|2[0-3])";
	private static String mm = "([0-5][0-9])";
	private static String SS = "([0-5][0-9])";
	private static String SSS = "([0-9][0-9][0-9])";
	

	private static String[] DATETIME_PATTERNS = {
			"^" + YYYY + MM + DD + HH + mm + SS +"$",
			"^" + YYYY + "-" + MM + "-" + DD + " " + HH + ":" + mm + ":" + SS + "$",
			"^" + YYYY + "/" + MM + "/" + DD + " " + HH + ":" + mm + ":" + SS + "$",
			"^" + YYYY + "." + MM + "." + DD + " " + HH + ":" + mm + ":" + SS + "$",
			"^" + YYYY + MM + DD + HH + mm + SS + SSS + "$",
			"^" + YYYY + "-" + MM + "-" + DD + " " + HH + ":" + mm + ":" + SS + "." + SSS + "$",
			"^" + YYYY + "/" + MM + "/" + DD + " " + HH + ":" + mm + ":" + SS + "." + SSS + "$",
			"^" + YYYY + "." + MM + "." + DD + " " + HH + ":" + mm + ":" + SS + "." + SSS + "$"
	};
			
	private static String[] DATETIME_FORMATS = {
			"yyyyMMddHHmmss",
			"yyyy-MM-dd HH:mm:ss",
			"yyyy/MM/dd HH:mm:ss",
			"yyyy.MM.dd HH:mm:ss",
			"yyyyMMddHHmmssSSS",
			"yyyy-MM-dd HH:mm:ss.SSS",
			"yyyy/MM/dd HH:mm:ss.SSS",
			"yyyy.MM.dd HH:mm:ss.SSS"
	};
	
	
	/**
	 * 
	 * @param dateStr
	 * @return
	 */
    public static LocalDateTime convert(String dateStr) {
    	LocalDateTime localDateTime = null;
    	try {
	    	for(int i=0; i <DATETIME_PATTERNS.length; i++ ) {
	    		if(Pattern.compile(DATETIME_PATTERNS[i]).matcher(dateStr).matches()) {
	    			localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(DATETIME_FORMATS[i]));
	    		}
	    	}
    	}catch(Exception e) {
    		throw new RuntimeException(e);
    	}
    	return localDateTime;
    }
    
    
    /**
     * LocalDate������ϊ�(yyyyMMddHHmmss)
     * @param localDateTime LocalDateTime
     * @return String(yyyyMMddHHmmss)
     */
    public static String convert(LocalDateTime localDateTime) {
    	return convert("yyyyMMddHHmmss",localDateTime);
    }
    
    /**
     * LocalDate������ϊ�(yyyy/MM/dd HH:mm:ss)
     * @param localDateTime LocalDateTime
     * @return String(yyyy/MM/dd HH:mm:ss)
     */
    public static String convertLog(LocalDateTime localDateTime){
    	return convert("yyyy/MM/dd HH:mm:ss",localDateTime);
    }

    /**
     * LocalDate������ϊ�(yyyy-MM-dd HH:mm:ss)
     * @param localDateTime LocalDateTime
     * @return String(yyyy-MM-dd HH:mm:ss)
     */
    public static String convertDb(LocalDateTime localDateTime){
    	return convert("yyyy-MM-dd HH:mm:ss",localDateTime);
    }
    
    /**
     * LocalDate������ϊ�(yyyy.MM.dd HH:mm:ss)
     * @param localDateTime LocalDateTime
     * @return String(yyyy.MM.dd)
     */
    public static String convertSimple(LocalDateTime localDateTime) {
    	return convert("yyyy.MM.dd HH:mm:ss",localDateTime);
    }
    
    /**
     * LocalDate������ϊ�(yyyyMMddHHmmssSSS)
     * @param localDateTime LocalDateTime
     * @return String(yyyyMMddHHmmssSSS)
     */
    public static String convertMills(LocalDateTime localDateTime) {
    	return convert("yyyyMMddHHmmssSSS",localDateTime);
    }
    
    /**
     * LocalDate������ϊ�(yyyy/MM/dd HH:mm:ss.SSS)
     * @param localDateTime LocalDateTime
     * @return String(yyyy/MM/dd HH:mm:ss.SSS)
     */
    public static String convertLogMills(LocalDateTime localDateTime){
    	return convert("yyyy/MM/dd HH:mm:ss.SSS",localDateTime);
    }

    /**
     * LocalDate������ϊ�(yyyy-MM-dd HH:mm:ss.SSS)
     * @param localDateTime LocalDateTime
     * @return String(yyyy-MM-dd HH:mm:ss.SSS)
     */
    public static String convertDbMills(LocalDateTime localDateTime){
    	return convert("yyyy-MM-dd HH:mm:ss.SSS",localDateTime);
    }
    
    /**
     * LocalDate������ϊ�(yyyy.MM.dd HH:mm:ss.SSS)
     * @param localDateTime LocalDateTime
     * @return String(yyyy.MM.dd.SSS)
     */
    public static String convertSimpleMills(LocalDateTime localDateTime) {
    	return convert("yyyy.MM.dd HH:mm:ss.SSS",localDateTime);
    }

    /**
     * ���������񃁃\�b�h
     * @param format �t�H�[�}�b�g
     * @param localDateTime LocalDateTime
     * @return String(format)
     */
    public static String convert(String format, LocalDateTime localDateTime) {
    	return DateTimeFormatter.ofPattern(format).format(localDateTime);
    }

    /**
     * �V�X�e�����t�𕶎���Ŏ擾
     * <per>
     * �f�t�H���g�̃��P�[���A�^�C���]�[���̓��t���擾
     * </pre>
     * @return SYSTEM���t�̕����� YYYYMMDDHHMMSS��ԋp
     */
    public static String getSysDate(){
        // TODO ������
        return (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")).format(new Date());
    }

    /**
     * �V�X�e�����t�𕶎���Ŏ擾
     * <per>
     * �f�t�H���g�̃��P�[���A�^�C���]�[���̓��t���擾
     * </pre>
     * @return SYSTEM���t�̕����� YYYYMMDDHHMMSS��ԋp
     */
    public static String getSysDate(String format){
        // TODO ������
        return (new SimpleDateFormat(format)).format(new Date());
    }
    
    
    //TODO DateTime�^���ǉ�
    
}
