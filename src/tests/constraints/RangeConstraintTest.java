package tests.constraints;

import DPPParser.defaultConstrains.RangeConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RangeConstraintTest {
    private RangeConstraint<Integer> rangeConstraint;
    private Integer lowerBound = -50;
    private Integer upperBound = 600;

    @BeforeClass
    public void initialize() {
        rangeConstraint = new RangeConstraint<Integer>(lowerBound, upperBound);
    }


    @Test
    public void testIsFulfilled_MinBoundaryValue_Pass() throws Exception {
        boolean result = rangeConstraint.isFulfilled(lowerBound);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_MaxBoundaryValue_Pass() throws Exception {
        boolean result = rangeConstraint.isFulfilled(upperBound);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_HigherValue_Pass() throws Exception {
        boolean result = rangeConstraint.isFulfilled(601);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilled_LowerValue_Pass() throws Exception {
        boolean result = rangeConstraint.isFulfilled(-51);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage_Pass() throws Exception {
        Assert.assertEquals(rangeConstraint.getErrorMessage(-50), "\"-50\" is not in the range of " + lowerBound
                + "-" + upperBound);
    }
}