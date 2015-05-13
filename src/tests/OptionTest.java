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
    Set<String> longSwitches;
    String firstShortSwitch;
    String secondShortSwitch;
    String firstLongSwitch;
    Set<String> shortSwitches;
    Option option;
    Option mandatoryOption;
    Argument<Integer> mandatoryOptionArg;

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

        option = new Option.Builder(firstShortSwitch)
                .addLongSwitches(longSwitches)
                .addShortSwitch(secondShortSwitch)
                .addLongSwitch(firstLongSwitch)
                .addShortSwitches(shortSwitches)
                .build();

        mandatoryOptionArg = new Argument(new UpperBoundConstraint(2), new IntegerArgumentParser());
        mandatoryOption = new Option.Builder(firstShortSwitch)
                .isMandatory(true)
                .setMandatoryArgument(mandatoryOptionArg, "Argument missing")
                .build();


    }

    @Test
    public void testHasShortSwitch() throws Exception {
        boolean returned = option.hasShortSwitch("s");
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasNotShortSwitch() throws Exception {
        boolean returned = option.hasShortSwitch("a");
        Assert.assertFalse(returned);
    }

    @Test
    public void testGetShortSwitches() throws Exception {
        Set<String> returned = option.getShortSwitches();
        Set<String> expected = new HashSet<String>();
        expected.addAll(shortSwitches);
        expected.add(firstShortSwitch);
        expected.add(secondShortSwitch);
        Assert.assertEquals(returned, expected);
    }

    @Test
    public void testHasLongSwitch() throws Exception {
        boolean returned = option.hasShortSwitch("first");
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasNotLongSwitch() throws Exception {
        boolean returned = option.hasShortSwitch("third");
        Assert.assertFalse(returned);
    }

    @Test
    public void testGetLongSwitches() throws Exception {
        Set<String> returned = option.getLongSwitches();
        Set<String> expected = new HashSet<String>();
        expected.addAll(longSwitches);
        expected.add(firstLongSwitch);
        Assert.assertEquals(returned, expected);
    }

    @Test
    public void testIsNotMandatory() throws Exception {
        boolean returned = option.isMandatory();
        Assert.assertFalse(returned);
    }

    @Test
    public void testIsMandatory() throws Exception {
        boolean returned = mandatoryOption.isMandatory();
        Assert.assertTrue(returned);
    }

    @Test
    public void testHasNotMandatoryArgument() throws Exception {
        boolean returned = option.hasMandatoryArgument();
        Assert.assertFalse(returned);
    }

    @Test
    public void testHasMandatoryArgument() throws Exception {
        boolean returned = mandatoryOption.hasMandatoryArgument();
        Assert.assertTrue(returned);
    }

    @Test
    public void testGetArgumentWhenMandatoryArgument() throws Exception {
        Argument<Integer> returned = mandatoryOption.getArgument();
        Assert.assertEquals(returned, mandatoryOptionArg);
    }

    @Test
    public void testGetArgumentWhenNoArgument() throws Exception {
        Argument<Integer> returned = option.getArgument();
        Assert.assertNull(returned);
    }

    @Test
    public void testHasArgument() throws Exception {

    }

    @Test
    public void testGetArgumentPresence() throws Exception {

    }

    @Test
    public void testGetDescription() throws Exception {

    }

    @Test
    public void testGetErrorMessage() throws Exception {

    }

    @Test
    public void testGetParseResult() throws Exception {

    }

    @Test
    public void testSetParseResult() throws Exception {

    }

    @Test
    public void testIsFailed() throws Exception {

    }

    @Test
    public void testIsExtra() throws Exception {

    }

    @Test
    public void testIsMissed() throws Exception {

    }
}