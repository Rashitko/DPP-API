package tests;

import DPPParser.arguments.Argument;
import DPPParser.defaultConstrains.UpperBoundConstraint;
import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import DPPParser.options.Parser;
import DPPParser.parsers.IntegerArgumentParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;


public class ParserTest {

    Set<String> longSwitches;
    String firstShortSwitch;
    String secondShortSwitch;
    String firstLongSwitch;
    Set<String> shortSwitches;
    Option simpleOption;
    Option mandatoryOptionWithMandatoryArg;
    Argument<Integer> argument;
    Option optionWithOptionalArg;
    String optionDescription;
    Parser parser;
    OptionsList optionsList;

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

        optionsList = new OptionsList();
        optionsList.add(simpleOption);
        optionsList.add(mandatoryOptionWithMandatoryArg);
        optionsList.add(optionWithOptionalArg);

        parser = new Parser(optionsList);
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