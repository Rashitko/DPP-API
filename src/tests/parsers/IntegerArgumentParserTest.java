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
    public void testParse_PositiveNumber_Pass() throws Exception {
        Integer result = parser.parse("1");
        Integer expected = 1;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveNumberBoundary_Pass() throws Exception {
        String integerMaxValue = Integer.MAX_VALUE + "";
        Integer result = parser.parse(integerMaxValue);
        Integer expected = Integer.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumber_Pass() throws Exception {
        Integer result = parser.parse("-122");
        Integer expected = -122;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumberBoundary_Pass() throws Exception {
        String integerMinValue = Integer.MIN_VALUE + "";
        Integer result = parser.parse(integerMinValue);
        Integer expected = Integer.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_Letter_ThrowException() throws Exception {
        Integer result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_OutOfRange_ThrowException() throws Exception {
        Integer result = parser.parse("999999999999999999999");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_FloatNumber_ThrowException() throws Exception {
        Integer result = parser.parse("5.5");
    }

    @Test
    public void testGetErrorMessage_Pass() {
        try {
            parser.parse("a");
        } catch (ParsingException e) {
            // ignore the exception on purpose
        }
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as integer");
    }

}