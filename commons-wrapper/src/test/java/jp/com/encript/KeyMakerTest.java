/**
 * 
 */
package jp.com.encript;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * @author Duran
 *
 */
public class KeyMakerTest {

    /**
     * Test method for {@link jp.com.encript.KeyMaker#create(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCreate() {
      String key = KeyMaker.create("12345678", "2020-03-31 23:59:48");
      System.out.println(key);
      assertThat(key.length(),is(30));
      
    }

    /**
     * Test method for {@link jp.com.encript.KeyMaker#create256(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testCreate256() {
      String key = KeyMaker.create256("12345678901234567890");
      System.out.println(key);
      assertThat(key.length(),is(64));
    }
}
