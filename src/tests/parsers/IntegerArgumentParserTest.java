package tests.parsers;

import DPPParser.parsers.IntegerArgumentParser;
import DPPParser.parsers.ParsingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class IntegerArgumentParserTest {

    private IntegerArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new IntegerArgumentParser();
    }

    @Test
    public void testParsePositiveNumber() throws Exception {
        Integer result = parser.parse("1");
        Integer expected = 1;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParsePositiveNumberBoundary() throws Exception {
        String integerMaxValue = Integer.MAX_VALUE + "";
        Integer result = parser.parse(integerMaxValue);
        Integer expected = Integer.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseNegativeNumber() throws Exception {
        Integer result = parser.parse("-122");
        Integer expected = -122;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseNegativeNumberBoundary() throws Exception {
        String integerMinValue = Integer.MIN_VALUE + "";
        Integer result = parser.parse(integerMinValue);
        Integer expected = Integer.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseLetter() throws Exception {
        Integer result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseOutOfRange() throws Exception {
        Integer result = parser.parse("999999999999999999999");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseFloatNumber() throws Exception {
        Integer result = parser.parse("5.5");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as integer");
    }

}