package tests.constraints;

import DPPParser.arguments.Constraint;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ComposedConstraintTest {

    private Constraint<Integer> composedConstraint;
    private Integer lowerBound = 5;
    private Integer upperBound = 20;

    @BeforeClass
    public void initialize() {
        Constraint.ConstraintBuilder<Integer> builder = new Constraint.ConstraintBuilder<Integer>(new LowerBoundConstraint<Integer>(lowerBound));
        // composedConstraint = new Constraint.ConstraintBuilder<Integer>(new LowerBoundConstraint<Integer>(lowerBound))
        //  .followedBy(new UpperBoundConstraint<Integer>(upperBound))
        //    .build();
    }

    @Test
    public void testIsFulfilled_MinBoundaryValue_Pass() throws Exception {
        boolean result = composedConstraint.isFulfilled(lowerBound);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_MaxBoundaryValue_Pass() throws Exception {
        boolean result = composedConstraint.isFulfilled(upperBound);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_HigherValue_Pass() throws Exception {
        boolean result = composedConstraint.isFulfilled(25);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilled_LowerValue_Pass() throws Exception {
        boolean result = composedConstraint.isFulfilled(2);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage_Pass() throws Exception {
        Assert.assertEquals(composedConstraint.getErrorMessage(-10),
                "LowerBoundConstraint : \"-10\" is not higher than " + lowerBound + "\n");
    }

}