package jp.com.util;


import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

import jp.com.util.DateTimeUtil;


class DateTimeUtilTest {

	@Test
	void testConvertString() {
		assertEquals(
				LocalDateTime.parse("20200202235959", DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
				DateTimeUtil.convert("20200202235959"));
	}

	@Test
	void testConvertLocalDateTime() {
		assertEquals(
				"20200202235959",
				DateTimeUtil.convert(LocalDateTime.parse("20200202235959", DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))));
	}

	@Test
	void testConvertLog() {
		assertEquals(
				"2020/02/02 23:59:59",
				DateTimeUtil.convertLog(LocalDateTime.parse("2020/02/02 23:59:59", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"))));
	}

	@Test
	void testConvertDb() {
		assertEquals(
				"2020-02-02 23:59:59",
				DateTimeUtil.convertDb(LocalDateTime.parse("2020-02-02 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
	}

	@Test
	void testConvertSimple() {
		assertEquals(
				"2020.02.02 23:59:59",
				DateTimeUtil.convertSimple(LocalDateTime.parse("2020.02.02 23:59:59", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"))));
	}

	@Test
	void testConvertMills() {
		assertEquals(
				"20200202235959999",
				DateTimeUtil.convertMills(LocalDateTime.parse("20200202235959999", DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"))));
	}

	@Test
	void testConvertLogMills() {
		assertEquals(
				"2020/02/02 23:59:59.999",
				DateTimeUtil.convertLogMills(LocalDateTime.parse("2020/02/02 23:59:59.999", DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss.SSS"))));
	}

	@Test
	void testConvertDbMills() {
		assertEquals(
				"2020-02-02 23:59:59.999",
				DateTimeUtil.convertDbMills(LocalDateTime.parse("2020-02-02 23:59:59.999", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))));
	}

	@Test
	void testConvertSimpleMills() {
		assertEquals(
				"2020.02.02 23:59:59.999",
				DateTimeUtil.convertSimpleMills(LocalDateTime.parse("2020.02.02 23:59:59.999", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS"))));
	}

	@Test
	void testConvertStringLocalDateTime() {
		assertEquals(
				"2020.02.02 23:59:59.999",
				DateTimeUtil.convert("yyyy.MM.dd HH:mm:ss.SSS",LocalDateTime.parse("2020.02.02 23:59:59.999", DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss.SSS"))));
	}

}
