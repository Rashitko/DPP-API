package tests.constraints;

import DPPParser.arguments.Constraint;
import DPPParser.defaultConstrains.IntegerConstraint;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ComposedConstraintTest {

    private Constraint<Integer> composedConstraint;
    private Integer lowerEvenBound = 6;

    @BeforeClass
    public void initialize() {
        Constraint<Integer> evenNumbersConstraint = new IntegerConstraint() {
            @Override
            public boolean isFulfilled(Integer argument) {
                if (argument % 2 == 0) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public String getErrorMessage(Integer argument) {
                return "\"" + argument + "\" is not divisible by two";
            }
        };
        composedConstraint = new Constraint.ConstraintBuilder<Integer>(new LowerBoundConstraint<Integer>(lowerEvenBound))
                .followedBy(evenNumbersConstraint)
                .build();
    }

    @Test
    public void testIsFulfilledMinBoundaryEvenValue() throws Exception {
        boolean result = composedConstraint.isFulfilled(lowerEvenBound);
        Assert.assertTrue(result);
    }


    @Test
    public void testIsFulfilledHigherEvenValue() throws Exception {
        boolean result = composedConstraint.isFulfilled(26);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledHigherOddValue() throws Exception {
        boolean result = composedConstraint.isFulfilled(25);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilledLowerEvenValue() throws Exception {
        boolean result = composedConstraint.isFulfilled(2);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsFulfilledLowerOddValue() throws Exception {
        boolean result = composedConstraint.isFulfilled(1);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(composedConstraint.getErrorMessage(4),
                "DPPParser.defaultConstrains.LowerBoundConstraint : \"4\" is not higher than " + lowerEvenBound + "\n");
    }

}