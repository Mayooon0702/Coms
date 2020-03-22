package jp.com.util;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.com.util.RandomUtil;

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
