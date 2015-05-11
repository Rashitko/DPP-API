package tests.constraints;

import DPPParser.defaultConstrains.LowerBoundConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LowerBoundConstraintTest {
    private LowerBoundConstraint<Integer> lowerBoundConstraint;
    private Integer lowerBound = 5;

    @BeforeClass
    public void initialize() {

        lowerBoundConstraint = new LowerBoundConstraint<Integer>(lowerBound);
    }


    @Test
    public void testIsFulfilled_BoundaryValue_Pass() throws Exception {
        boolean result = lowerBoundConstraint.isFulfilled(5);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_HigherValue_Pass() throws Exception {
        boolean result = lowerBoundConstraint.isFulfilled(10);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_LowerValue_Pass() throws Exception {
        boolean result = lowerBoundConstraint.isFulfilled(-2);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage_St_Pass() throws Exception {
        Assert.assertEquals(lowerBoundConstraint.getErrorMessage(2), "\"" + 2 + "\" is not higher than " + lowerBound);
    }
}