package tests.constraints;

import DPPParser.defaultConstrains.AllowedSetConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AllowedSetConstraintStringsTest {

    private final String[] correctValues = {"one", "three"};
    private final String forbiddenValue = "two";
    private AllowedSetConstraint<String> allowedSetConstraint;

    @BeforeClass
    public void initialize() {
        allowedSetConstraint = new AllowedSetConstraint<String>();
        allowedSetConstraint.add(correctValues[0]);
        allowedSetConstraint.add(correctValues[1]);
    }

    @Test
    public void testIsFulfilledStringCorrectCase() throws Exception {
        boolean result = allowedSetConstraint.isFulfilled(correctValues[1]);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilledStringForbiddenCase() throws Exception {
        boolean result = allowedSetConstraint.isFulfilled(forbiddenValue);
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertEquals(allowedSetConstraint.getErrorMessage(forbiddenValue),
                "\"" + forbiddenValue + "\" is not allowed. Allowed arguments are:" + allowedSetConstraint);
    }
}