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
    public void testParsePositiveNumber() throws Exception {
        Short result = parser.parse("1");
        Short expected = 1;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParsePositiveNumberBoundary() throws Exception {
        String shortMaxValue = Short.MAX_VALUE + "";
        Short result = parser.parse(shortMaxValue);
        Short expected = Short.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseNegativeNumber() throws Exception {
        Short result = parser.parse("-122");
        Short expected = -122;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseNegativeNumberBoundary() throws Exception {
        String shortMinValue = Short.MIN_VALUE + "";
        Short result = parser.parse(shortMinValue);
        Short expected = Short.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseLetter() throws Exception {
        Short result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseOutOfRange() throws Exception {
        Short result = parser.parse("999999999999999999999");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseFloatNumber() throws Exception {
        Short result = parser.parse("5.5");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as short");
    }

}