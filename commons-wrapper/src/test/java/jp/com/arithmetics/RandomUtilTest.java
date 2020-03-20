package jp.com.arithmetics;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomUtilTest {

    @Test
    public void testGetStringUUID() {
	System.out.println(RandomUtil.getRandom());
	
    }

    @Test
    public void testGetRandom() {
	System.out.println(RandomUtil.getStringUUID());
	
    }

}
