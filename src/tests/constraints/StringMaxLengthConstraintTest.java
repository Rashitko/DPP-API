package tests.constraints;

import DPPParser.defaultConstrains.StringMaxLengthConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StringMaxLengthConstraintTest {
    private StringMaxLengthConstraint constraint;
    private Integer maxLength = 5;

    @BeforeClass
    public void initialize() {
        constraint = new StringMaxLengthConstraint(maxLength);
    }

    @Test
    public void testIsFulfilledBoundaryLength() throws Exception {
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
        boolean result = constraint.isFulfilled("cat");
        Assert.assertTrue(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(constraint.getErrorMessage("mountain"), "\"mountain\" length is not lower than" + maxLength);
    }
}