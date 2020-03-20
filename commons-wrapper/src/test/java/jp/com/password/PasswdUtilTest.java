/**
 * 
 */
package jp.com.password;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * 
 *
 */
public class PasswdUtilTest {

	/**
	 * Test method for {@link jp.com.password.PassedUtil#createNew8()}.
	 */
	@Test
	public void testCreateNew8() {
		String newPasswd = PasswdUtil.createNew8();
		System.out.println("passwd="+newPasswd);
		assertThat(Integer.toString(newPasswd.length()),is("8"));
	}
}
