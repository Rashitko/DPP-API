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
    public void testIsFulfilledBoundaryValue() throws Exception {
        boolean result = upperBoundConstraint.isFulfilled("BoundaryString");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledHigherValue() throws Exception {
        boolean result = upperBoundConstraint.isFulfilled("Ganga");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilledLowerValue() throws Exception {
        boolean result = upperBoundConstraint.isFulfilled("Alabama");
        Assert.assertTrue(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(upperBoundConstraint.getErrorMessage("Ganga"), "\"Ganga\" is not lower than " + upperBound);
    }
}