package tests.constraints;

import DPPParser.defaultConstrains.StringLengthConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class StringLengthConstraintTest {
    private StringLengthConstraint constraint;
    private Integer minLength = 3;
    private Integer maxLength = 5;

    @BeforeClass
    public void initialize() {
        constraint = new StringLengthConstraint(minLength, maxLength);
    }


    @Test
    public void testIsFulfilled_MinBoundaryValue_Pass() throws Exception {
        boolean result = constraint.isFulfilled("cat");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_MaxBoundaryValue_Pass() throws Exception {
        boolean result = constraint.isFulfilled("house");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_HigherValue_Pass() throws Exception {
        boolean result = constraint.isFulfilled("mountain");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilled_LowerValue_Pass() throws Exception {
        boolean result = constraint.isFulfilled("at");
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage_Pass() throws Exception {
        Assert.assertEquals(constraint.getErrorMessage("at"), "\"at\" length is not in the range of "
                + minLength + "-" + maxLength);
    }
}