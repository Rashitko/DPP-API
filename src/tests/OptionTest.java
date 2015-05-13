package tests;

import DPPParser.arguments.Argument;
import DPPParser.defaultConstrains.UpperBoundConstraint;
import DPPParser.options.Option;
import DPPParser.parsers.IntegerArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


public class OptionTest {
    public static final String SWITCH_VALIDATION_REGEX = "^[a-zA-Z]+([\\w\\-_a-zA-Z_0-9]*[\\w_a-zA-Z_0-9]+|[\\w_a-zA-Z_0-9]*)$";

    private Set<String> longSwitches;
    private Set<String> shortSwitches;

    private String firstShortSwitch;
    private String secondShortSwitch;
    private String firstLongSwitch;

    private Option simpleOption;
    private Option mandatoryOptionWithMandatoryArg;
    private Option optionWithOptionalArg;

    private Argument<Integer> argument;
    private String optionDescription;

    @BeforeClass
    public void initialize() {
        firstLongSwitch = "fourth";
        firstShortSwitch = "s";
        secondShortSwitch = "u";

        longSwitches = new HashSet<String>();
        longSwitches.add("first");
        longSwitches.add("second");

        shortSwitches = new HashSet<String>();
        shortSwitches.add("x");

        simpleOption = new Option.Builder(firstShortSwitch)
                .addLongSwitches(longSwitches)
                .addShortSwitch(secondShortSwitch)
                .addLongSwitch(firstLongSwitch)
                .addShortSwitches(shortSwitches)
                .build();

        argument = new Argument(new UpperBoundConstraint(2), new IntegerArgumentParser());
        mandatoryOptionWithMandatoryArg = new Option.Builder(firstShortSwitch)
                .isMandatory(true)
                .setMandatoryArgument(argument, "Argument missing")
                .build();

        optionDescription = "Option description";
        optionWithOptionalArg = new Option.Builder(firstShortSwitch)
                .setOptionalArgument(argument)
                .setDescription(optionDescription)
                .build();
    }

    @Test
    public void testHasShortSwitch() throws Exception {
        boolean returned = simpleOption.hasShortSwitch("s");
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasNotShortSwitch() throws Exception {
        boolean returned = simpleOption.hasShortSwitch("a");
        Assert.assertFalse(returned);
    }

    @Test
    public void testGetShortSwitches() throws Exception {
        Set<String> returned = simpleOption.getShortSwitches();
        Set<String> expected = new HashSet<String>();
        expected.addAll(shortSwitches);
        expected.add(firstShortSwitch);
        expected.add(secondShortSwitch);
        Assert.assertEquals(returned, expected);
    }

    @Test
    public void testHasLongSwitch() throws Exception {
        boolean returned = simpleOption.hasLongSwitch("first");
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasNotLongSwitch() throws Exception {
        boolean returned = simpleOption.hasLongSwitch("third");
        Assert.assertFalse(returned);
    }

    @Test
    public void testGetLongSwitches() throws Exception {
        Set<String> returned = simpleOption.getLongSwitches();
        Set<String> expected = new HashSet<String>();
        expected.addAll(longSwitches);
        expected.add(firstLongSwitch);
        Assert.assertEquals(returned, expected);
    }

    @Test
    public void testIsNotMandatory() throws Exception {
        boolean returned = simpleOption.isMandatory();
        Assert.assertFalse(returned);
    }

    @Test
    public void testIsMandatory() throws Exception {
        boolean returned = mandatoryOptionWithMandatoryArg.isMandatory();
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasNotMandatoryArgument() throws Exception {
        boolean returned = simpleOption.hasMandatoryArgument();
        Assert.assertFalse(returned);
    }

    @Test
    public void testHasMandatoryArgument() throws Exception {
        boolean returned = mandatoryOptionWithMandatoryArg.hasMandatoryArgument();
        Assert.assertTrue(returned);
    }

    @Test
    public void testGetArgumentWhenMandatoryArgument() throws Exception {
        Argument<Integer> returned = mandatoryOptionWithMandatoryArg.getArgument();
        Assert.assertEquals(returned, argument);
    }

    @Test
    public void testGetArgumentWhenNoArgument() throws Exception {
        Argument<Integer> returned = simpleOption.getArgument();
        Assert.assertNull(returned);
    }

    @Test
    public void testHasArgumentWhenNoArgument() throws Exception {
        boolean returned = simpleOption.hasArgument();
        Assert.assertFalse(returned);
    }

    @Test
    public void testHasArgumentWhenMandatoryArgument() throws Exception {
        boolean returned = mandatoryOptionWithMandatoryArg.hasArgument();
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasArgumentWhenOptionalArgument() throws Exception {
        boolean returned = optionWithOptionalArg.hasArgument();
        Assert.assertTrue(returned);
    }

    @Test
    public void testGetArgumentPresenceNoArgument() throws Exception {
        Option.ArgumentPresence presence = simpleOption.getArgumentPresence();
        Assert.assertNull(presence);
    }

    @Test
    public void testGetArgumentPresenceMandatoryArgument() throws Exception {
        Option.ArgumentPresence presence = mandatoryOptionWithMandatoryArg.getArgumentPresence();
        Assert.assertEquals(presence, Option.ArgumentPresence.MANDATORY);
    }

    @Test
    public void testGetArgumentPresenceOptionalArgument() throws Exception {
        Option.ArgumentPresence presence = optionWithOptionalArg.getArgumentPresence();
        Assert.assertEquals(presence, Option.ArgumentPresence.OPTIONAL);
    }

    @Test
    public void testGetDescriptionWhenNoDescription() throws Exception {
        String description = simpleOption.getDescription();
        Assert.assertEquals(description, "Description is not available for this option");
    }

    @Test
    public void testGetDescriptionWhenDescriptionSet() throws Exception {
        String description = optionWithOptionalArg.getDescription();
        Assert.assertEquals(description, optionDescription);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        Assert.assertNull(simpleOption.getErrorMessage());
    }

    @Test
    public void testGetParseResult() throws Exception {
        Assert.assertNull(simpleOption.getParseResult());
    }


    @Test
    public void testSwitchValidationShort() throws Exception {
        Assert.assertTrue("n".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationLong() throws Exception {
        Assert.assertTrue("longSwitch".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationWithNum() throws Exception {
        Assert.assertTrue("long11".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationWithDashes() throws Exception {
        Assert.assertTrue("lon--g11".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationStartWithTwoDashes() throws Exception {
        Assert.assertFalse("--lon--g11".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationStartWithOneDash() throws Exception {
        Assert.assertFalse("-lon--g11".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationStartWithNum() throws Exception {
        Assert.assertFalse("11".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationEndWithOneDash() throws Exception {
        Assert.assertFalse("a1-".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationEndWithTwoDashes() throws Exception {
        Assert.assertFalse("a1--".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationEndWithEqualSign() throws Exception {
        Assert.assertFalse("a1-=".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationStartWithEqualSign() throws Exception {
        Assert.assertFalse("=a1-".matches(SWITCH_VALIDATION_REGEX));
    }

    @Test
    public void testSwitchValidationEqualSignInside() throws Exception {
        Assert.assertFalse("a=1".matches(SWITCH_VALIDATION_REGEX));
    }
}