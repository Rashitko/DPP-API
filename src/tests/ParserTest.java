package tests;

import DPPParser.arguments.Argument;
import DPPParser.arguments.Constraint;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import DPPParser.parsers.LongArgumentParser;
import DPPParser.parsers.StringArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParserTest {

    public static final String SHORT_INT_OPT_SWITCH = "short";
    public static final String SHORT_INT_OPT_WITH_CONSTR_SWITCH = "swc";
    public static final String LONG_OPT_WITH_MANGATORY_ARG_SWITCH = "lowma";
    public static final String MANDATORY_STRING_OPT_SWITCH = "mso";
    private Option shortIntOption;
    private Parser parser;
    private OptionsList options;
    private Option shortIntOptionWithConstr;
    private Option longIntOptionWithMandatoryArg;
    private Option mandatoryStringOpt;

    @BeforeMethod
    public void initialize() {
        options = new OptionsList();
        Argument intArgument = new Argument<Integer>(new IntegerArgumentParser());

        shortIntOption = new Option.Builder(SHORT_INT_OPT_SWITCH)
                .setOptionalArgument(intArgument)
                .build();
        options.add(shortIntOption);

        Constraint<Integer> greaterThanZeroConstr = new LowerBoundConstraint<Integer>(0);
        Argument<Integer> intArgumentWithConstr = new Argument<Integer>(greaterThanZeroConstr, new IntegerArgumentParser());
        shortIntOptionWithConstr = new Option.Builder(SHORT_INT_OPT_WITH_CONSTR_SWITCH)
                .setOptionalArgument(intArgumentWithConstr)
                .build();
        options.add(shortIntOptionWithConstr);

        Argument longArgument = new Argument<Long>(new LongArgumentParser());
        longIntOptionWithMandatoryArg = new Option.Builder(LONG_OPT_WITH_MANGATORY_ARG_SWITCH, Option.Builder.SwitchType.LONG_SWITCH)
                .setMandatoryArgument(longArgument, null)
                .build();
        options.add(longIntOptionWithMandatoryArg);

        Argument<String> stringArgument = new Argument<String>(new StringArgumentParser());
        mandatoryStringOpt = new Option.Builder(MANDATORY_STRING_OPT_SWITCH)
                .isMandatory(true)
                .setMandatoryArgument(stringArgument, null)
                .build();
        options.add(mandatoryStringOpt);

        parser = new Parser(options);
    }

    @Test
    public void testSingleValidShortSwitchWithoutConstraints() {
        String[] args = {"-" + SHORT_INT_OPT_SWITCH, "150"};
        parser.resolveOptions(args);
        Assert.assertEquals(shortIntOption.getArgument().getValue(), 150);
    }

    @Test
    public void testSingleValidShortSwitchWithFulfilledConstraint() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "150"};
        parser.resolveOptions(args);
        Assert.assertEquals(shortIntOptionWithConstr.getArgument().getValue(), 150);
        Assert.assertTrue(shortIntOptionWithConstr.isSuccessful());
    }

    @Test
    public void testSingleValidShortSwitchWithFailedConstraint() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "-123"};
        parser.resolveOptions(args);
        Assert.assertEquals(shortIntOptionWithConstr.getArgument().getValue(), -123);
        Assert.assertEquals(shortIntOptionWithConstr.getParseResult(), Option.ParseResult.CONSTRAINT_FAILED);
    }

    @Test
    public void testSingleInvalidShortSwitch() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "auticko"};
        parser.resolveOptions(args);
        Assert.assertNull(shortIntOptionWithConstr.getArgument().getValue());
        Assert.assertEquals(shortIntOptionWithConstr.getParseResult(), Option.ParseResult.PARSING_FAILED);
        Assert.assertTrue(shortIntOptionWithConstr.isFailed());
    }

    @Test
    public void testMultipleValidShortSwitches() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "123", "-" + SHORT_INT_OPT_SWITCH, "1500"};
        parser.resolveOptions(args);
        Assert.assertEquals(shortIntOptionWithConstr.getArgument().getValue(), 123);
        Assert.assertEquals(shortIntOption.getArgument().getValue(), 1500);
    }

    @Test
    public void testMultipleShortSwitchesWithOneInvalidValue() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "123", "-" + SHORT_INT_OPT_SWITCH, "auticko"};
        parser.resolveOptions(args);
        Assert.assertEquals(shortIntOptionWithConstr.getArgument().getValue(), 123);
        Assert.assertNull(shortIntOption.getArgument().getValue());
        Assert.assertEquals(shortIntOption.getParseResult(), Option.ParseResult.PARSING_FAILED);
    }

    @Test
    public void testMissingMandatoryArgument() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "123", "-" + SHORT_INT_OPT_SWITCH, "1500", "--" + LONG_OPT_WITH_MANGATORY_ARG_SWITCH};
        parser.resolveOptions(args);
        Assert.assertEquals(longIntOptionWithMandatoryArg.getParseResult(), Option.ParseResult.ARGUMENT_MISSED);
        Assert.assertNull(longIntOptionWithMandatoryArg.getArgument().getValue());
    }

    @Test
    public void testInvalidMandatoryArgument() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "123", "-" + SHORT_INT_OPT_SWITCH, "1500", "--" + LONG_OPT_WITH_MANGATORY_ARG_SWITCH, "auticko"};
        parser.resolveOptions(args);
        Assert.assertEquals(longIntOptionWithMandatoryArg.getParseResult(), Option.ParseResult.PARSING_FAILED);
        Assert.assertNull(longIntOptionWithMandatoryArg.getArgument().getValue());
    }

    @Test
    public void testMissingMandatoryOption() {
        String[] args = {"-" + SHORT_INT_OPT_WITH_CONSTR_SWITCH, "123", "-" + SHORT_INT_OPT_SWITCH, "1500"};
        parser.resolveOptions(args);
        Assert.assertEquals(mandatoryStringOpt.getParseResult(), Option.ParseResult.OPTION_MISSED);
    }

}