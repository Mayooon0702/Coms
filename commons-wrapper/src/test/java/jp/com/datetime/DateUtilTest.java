package jp.com.datetime;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

class DateUtilTest {

	@Test
	void testConvertString() {
		assertEquals(
				LocalDate.parse("20200202", DateTimeFormatter.ofPattern("yyyyMMdd")),
				DateUtil.convert("20200202"));
	}

	@Test
	void testConvertLocalDate() {
		assertEquals(
				"20200201",
				DateUtil.convert(LocalDate.parse("20200201", DateTimeFormatter.ofPattern("yyyyMMdd"))));
	}

	@Test
	void testConvertLog() {
		assertEquals(
				"2020/01/31",
				DateUtil.convertLog(LocalDate.parse("2020/01/31", DateTimeFormatter.ofPattern("yyyy/MM/dd"))));
	}

	@Test
	void testConvertDb() {
		assertEquals(
				"2020-01-29",
				DateUtil.convertDb(LocalDate.parse("2020-01-29", DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
	}

	@Test
	void testConvertSimple() {
		assertEquals(
				"2020.01.28",
				DateUtil.convertSimple(LocalDate.parse("2020.01.28", DateTimeFormatter.ofPattern("yyyy.MM.dd"))));
	}

	@Test
	void testConvertStringLocalDate() {
		assertEquals(
				"2020.01.27",
				DateUtil.convert("yyyy.MM.dd", LocalDate.parse("2020.01.27", DateTimeFormatter.ofPattern("yyyy.MM.dd"))));
	}

}
