package tests.constraints;

import DPPParser.defaultConstrains.StringLengthConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StringLengthConstraintTest {
    private final int minLength = 3;
    private final int maxLength = 5;
    private StringLengthConstraint constraint;

    @BeforeClass
    public void initialize() {
        constraint = new StringLengthConstraint(minLength, maxLength);
    }


    @Test
    public void testIsFulfilledMinBoundaryValue() throws Exception {
        boolean result = constraint.isFulfilled("cat");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledMaxBoundaryValue() throws Exception {
        boolean result = constraint.isFulfilled("house");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledHigherValue() throws Exception {
        boolean result = constraint.isFulfilled("mountain");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilledLowerValue() throws Exception {
        boolean result = constraint.isFulfilled("at");
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(constraint.getErrorMessage("at"), "\"at\" length is not in the range of "
                + minLength + "-" + maxLength);
    }
}