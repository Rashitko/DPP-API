package tests.constraints;

import DPPParser.defaultConstrains.StringMinLengthConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StringMinLengthConstraintTest {
    private StringMinLengthConstraint constraint;
    private Integer minLength = 3;

    @BeforeClass
    public void initialize() {
        constraint = new StringMinLengthConstraint(minLength);
    }

    @Test
    public void testIsFulfilledBoundaryLength() throws Exception {
        boolean result = constraint.isFulfilled("foo");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledHigherValue() throws Exception {
        boolean result = constraint.isFulfilled("hello");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledLowerValue() throws Exception {
        boolean result = constraint.isFulfilled("at");
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(constraint.getErrorMessage("at"), "\"at\" length is not higher than" + minLength);
    }
}