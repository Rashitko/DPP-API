package tests;

import DPPParser.arguments.Argument;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class BasicParserTest {

    final int SIZE_LOWER_BOUND = 0;
    Option verbose;
    Argument<Integer> sizeArg;
    Option size;
    OptionsList options;
    Parser parser;

    @BeforeClass
    public void initialize() {
        // INITIALIZE OPTIONS
        verbose = new Option.Builder("v")
                .addLongSwitch("verbose")
                .build();
        sizeArg = new Argument<Integer>(
                new LowerBoundConstraint<Integer>(SIZE_LOWER_BOUND),
                new IntegerArgumentParser());
        size = new Option.Builder("s")
                .addLongSwitch("size")
                .setOptionalArgument(sizeArg)
                .build();
        options = new OptionsList();
        options.add(verbose);
        options.add(size);

        //INSTANTIATE PARSER
        parser = new Parser(options);
        String[] argArray = {"-v", "--verbose", "-s", "OLD", "--length=20", "--", "-my-file", "your-file"};
        parser.resolveOptions(argArray);
    }

    @Test
    public void testGetFailedOptions() throws Exception {

        Assert.assertEquals(parser.getFailedOptions().size(), 1);
        List<Option> expected = new ArrayList<Option>();
        expected.add(size);
        Assert.assertEquals(parser.getFailedOptions().get(0).getLongSwitches(), size.getLongSwitches());
        Assert.assertEquals(parser.getFailedOptions().get(0).getShortSwitches(), size.getShortSwitches());
    }

    @Test
    public void testGetExtraOptions() throws Exception {
        Assert.assertEquals(parser.getExtraOptions().size(), 1);
        List<String> expected = new ArrayList<String>();
        expected.add("length");
        Assert.assertEquals(parser.getExtraOptions().get(0).getLongSwitches(), expected);
    }

    @Test
    public void testGetMissedOptions() throws Exception {
        Assert.assertEquals(parser.getMissedOptions().size(), 0);
    }

    @Test
    public void testHasError() throws Exception {
        Assert.assertTrue(parser.hasError());
    }

    @Test
    public void testGetUnmatchedArguments() throws Exception {
        Assert.assertEquals(parser.getUnmatchedArguments().size(), 0);
    }

    @Test
    public void testGetRegularArguments() throws Exception {
        Assert.assertEquals(parser.getRegularArguments().size(), 2);
        List<String> expected = new ArrayList<String>();
        expected.add("-my-file");
        expected.add("your-file");
        Assert.assertEquals(parser.getRegularArguments(), expected);
    }

    @Test
    public void optionFailedTest() {
        boolean returned = size.isFailed();
        Assert.assertTrue(returned);
    }

    @Test
    public void optionSuccesTest() {
        boolean returned = verbose.isSuccessful();
        Assert.assertTrue(returned);
    }
}