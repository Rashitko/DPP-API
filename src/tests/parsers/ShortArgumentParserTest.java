package tests.parsers;

import DPPParser.parsers.ParsingException;
import DPPParser.parsers.ShortArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ShortArgumentParserTest {

    private ShortArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new ShortArgumentParser();
    }

    @Test
    public void testParse_PositiveNumber_Pass() throws Exception {
        Short result = parser.parse("1");
        Short expected = 1;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveNumberBoundary_Pass() throws Exception {
        String shortMaxValue = Short.MAX_VALUE + "";
        Short result = parser.parse(shortMaxValue);
        Short expected = Short.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumber_Pass() throws Exception {
        Short result = parser.parse("-122");
        Short expected = -122;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumberBoundary_Pass() throws Exception {
        String shortMinValue = Short.MIN_VALUE + "";
        Short result = parser.parse(shortMinValue);
        Short expected = Short.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_Letter_ThrowException() throws Exception {
        Short result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_OutOfRange_ThrowException() throws Exception {
        Short result = parser.parse("999999999999999999999");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_FloatNumber_ThrowException() throws Exception {
        Short result = parser.parse("5.5");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage_Pass() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as short");
    }

}