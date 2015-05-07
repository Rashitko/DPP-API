package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConstraintTest {

    @Test
    public void testIsFulfilled() throws Exception {
        Assert.assertEquals("aaa", "bbb");
    }

    @Test
    public void testGetErrorMessage() throws Exception {

    }
}