package tests;

import DPPParser.arguments.Argument;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import DPPParser.parsers.StringArgumentParser;
import org.junit.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class UnusualInputsParserTests {

    private Option shortOption;
    private Parser parser;
    private Option shortOptionWithStringArg;

    @BeforeMethod
    public void initialize() {
        OptionsList options = new OptionsList();

        Argument<Integer> intArg = new Argument<Integer>(new IntegerArgumentParser());
        shortOption = new Option.Builder("short")
                .setOptionalArgument(intArg)
                .build();
        options.add(shortOption);
        Argument<String> stringArg = new Argument<String>(new StringArgumentParser());
        shortOptionWithStringArg = new Option.Builder("s")
                .setMandatoryArgument(stringArg, null)
                .build();
        options.add(shortOptionWithStringArg);

        parser = new Parser(options);
    }

    @Test
    public void testMultipleArgs() {
        String[] args = {"-short", "1", "123"};
        parser.resolveOptions(args);
        Assert.assertNotNull(shortOption.getArgument(), "-short should have argument");
        Assert.assertEquals(shortOption.getArgument().getValue(), 1, "value should be 1");
        Assert.assertEquals(parser.getUnmatchedArguments().size(), 1, "size of unmatched arguments should be 1");
        Assert.assertEquals(parser.getUnmatchedArguments().get(0), "123", "unmatchedArguments should have " + '"' + "123" + '"' + " on index 0");
    }

    @Test
    public void testNotexistingMalformedSwitch() {
        String[] args = {"---not-existing"};
        parser.resolveOptions(args);
        Assert.assertEquals(parser.getExtraOptions().size(), 1, "there should be 1 extra option");
        Option extraOption = parser.getExtraOptions().get(0);
        Assert.assertTrue(extraOption.isExtra(), "option should be extra");
        Assert.assertEquals(extraOption.getLongSwitches().size(), 1, "option should have 1 long switch");
        Assert.assertEquals(extraOption.getShortSwitches().size(), 0, "option should have 0 short switches");
        Assert.assertTrue(extraOption.getLongSwitches().contains("-not-existing"), "option should have long switch -not-existing");
    }

    @Test
    public void testNotexistingMalformedSwitchAfterValidOption() {
        String[] args = {"-s", "---not-existing"};
        parser.resolveOptions(args);
        Assert.assertTrue(shortOptionWithStringArg.hasArgument(), "-s should have argument");
        Assert.assertTrue(shortOptionWithStringArg.isFailed(), "-s should be failed");
        Assert.assertEquals(parser.getExtraOptions().size(), 1, "there should be 1 extra option");
        Option extraOption = parser.getExtraOptions().get(0);
        Assert.assertTrue(extraOption.isExtra(), "---not-existing should be extra");
        Assert.assertEquals(extraOption.getLongSwitches().size(), 1, "---not-existing should have 1 long switch");
        Assert.assertEquals(extraOption.getShortSwitches().size(), 0, "---not-existing should have 0 short switches");
        Assert.assertTrue(extraOption.getLongSwitches().contains("-not-existing"), "---not-existing should have long switch -not-existing");
    }

    @Test
    public void testMultipleParsingsWithOneOptionDefinition() {
        Option option = new Option.Builder("s")
                .setMandatoryArgument(new Argument<Integer>(new IntegerArgumentParser()), null)
                .build();
        OptionsList localOptions = new OptionsList();
        localOptions.add(option);
        Parser localParser = new Parser(localOptions);

        String[] args = {"-s", "123"};
        localParser.resolveOptions(args);
        Assert.assertTrue(option.isSuccessful(), "option should be successful");
        Assert.assertEquals(option.getArgument().getValue(), 123, "value should be 123");

        String[] argsWithoutVal = {"-s"};
        localParser.resolveOptions(argsWithoutVal);
        Assert.assertTrue(option.isFailed(), "option should be failed");
        Assert.assertNull(option.getArgument().getValue(), "option should not have argument");
    }

}
