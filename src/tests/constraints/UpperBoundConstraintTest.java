package tests.constraints;

import DPPParser.defaultConstrains.UpperBoundConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UpperBoundConstraintTest {
    private UpperBoundConstraint<String> upperBoundConstraint;
    private String upperBound = "BoundaryString";

    @BeforeClass
    public void initialize() {
        upperBoundConstraint = new UpperBoundConstraint<String>(upperBound);
    }


    @Test
    public void testIsFulfilled_BoundaryValue_Pass() throws Exception {
        boolean result = upperBoundConstraint.isFulfilled("BoundaryString");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_HigherValue_Pass() throws Exception {
        boolean result = upperBoundConstraint.isFulfilled("Ganga");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilled_LowerValue_Pass() throws Exception {
        boolean result = upperBoundConstraint.isFulfilled("Alabama");
        Assert.assertTrue(result);
    }

    @Test
    public void testGetErrorMessage_Pass() throws Exception {
        Assert.assertEquals(upperBoundConstraint.getErrorMessage("Ganga"), "\"Ganga\" is not lower than " + upperBound);
    }
}