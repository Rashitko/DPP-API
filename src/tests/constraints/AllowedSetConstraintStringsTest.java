package tests.constraints;

import DPPParser.defaultConstrains.AllowedSetConstraint;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AllowedSetConstraintStringsTest {

    private AllowedSetConstraint<String> allowedSetConstraint;

    @BeforeClass
    public void initialize() {
        allowedSetConstraint = new AllowedSetConstraint<String>();
        allowedSetConstraint.add("one");
        allowedSetConstraint.add("three");
    }

    @Test
    public void testIsFulfilled_StringCorrectCase_Pass() throws Exception {
        boolean result = allowedSetConstraint.isFulfilled("three");
        Assert.assertTrue(result);
    }

    @Test
    public void testIsFulfilled_StringForbiddenCase_Pass() throws Exception {
        boolean result = allowedSetConstraint.isFulfilled("two");
        Assert.assertFalse(result);
    }

    @Test
    public void testGetErrorMessage_String_Pass() throws Exception {
        Assert.assertEquals(allowedSetConstraint.getErrorMessage("two"),
                "\"two\" is not allowed. Allowed arguments are:" + allowedSetConstraint);
    }
}