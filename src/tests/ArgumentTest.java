package tests;

import DPPParser.arguments.Argument;
import DPPParser.arguments.Constraint;
import DPPParser.defaultConstrains.LowerBoundConstraint;
import DPPParser.parsers.IntegerArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ArgumentTest {

    private Argument<Integer> argument;
    private Constraint<Integer> constraint;
    private int lowerBound = 5;
    private IntegerArgumentParser parser;

    @BeforeClass
    public void initialize() throws Exception {
        constraint = new LowerBoundConstraint<Integer>(lowerBound);
        parser = new IntegerArgumentParser();
        argument = new Argument<Integer>(constraint, parser);
    }

    @Test
    public void testGetConstraint() throws Exception {
        Assert.assertEquals(argument.getConstraint(), constraint);
    }

    @Test
    public void testGetArgumentParser() throws Exception {
        Assert.assertEquals(argument.getArgumentParser(), parser);
    }


}