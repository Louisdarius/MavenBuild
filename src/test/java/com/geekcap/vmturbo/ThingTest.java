package com.geekcap.vmturbo;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shaines on 7/24/16.
 */

/**
 * Another comment added by Louis @15:11 on the 6 Jun 2023.
 */
public class ThingTest {

    @Test
    public void testN() {
        Thing t = new Thing();
        t.setN(5);
        Assert.assertEquals("N should be 5", 5, t.getN());
    }
}
