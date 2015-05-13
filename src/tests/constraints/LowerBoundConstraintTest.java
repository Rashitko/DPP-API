package tests.constraints;

import DPPParser.defaultConstrains.LowerBoundConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LowerBoundConstraintTest {
    private final int lowerBound = 5;
    private LowerBoundConstraint<Integer> lowerBoundConstraint;

    @BeforeClass
    public void initialize() {
        lowerBoundConstraint = new LowerBoundConstraint<Integer>(lowerBound);
    }


    @Test
    public void testIsFulfilledBoundaryValue() throws Exception {
        boolean result = lowerBoundConstraint.isFulfilled(5);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledHigherValue() throws Exception {
        boolean result = lowerBoundConstraint.isFulfilled(10);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledLowerValue() throws Exception {
        boolean result = lowerBoundConstraint.isFulfilled(-2);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(lowerBoundConstraint.getErrorMessage(2), "\"" + 2 + "\" is not higher than " + lowerBound);
    }
}