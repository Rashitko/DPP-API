package tests;

import DPPParser.arguments.Argument;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ParserRegularUseTest {

    final int SIZE_LOWER_BOUND = 0;
    final int SIZE_DEFAULT = 42;
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
    }

    @Test
    public void testResolveOptions() throws Exception {

    }

    @Test
    public void testGetFailedOptions() throws Exception {

    }

    @Test
    public void testGetExtraOptions() throws Exception {

    }

    @Test
    public void testGetMissedOptions() throws Exception {

    }

    @Test
    public void testHasError() throws Exception {

    }

    @Test
    public void testGetUnmatchedArguments() throws Exception {

    }

    @Test
    public void testGetRegularArguments() throws Exception {

    }
}