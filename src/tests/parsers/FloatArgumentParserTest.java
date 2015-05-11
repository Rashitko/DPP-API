package tests.parsers;

import DPPParser.parsers.FloatArgumentParser;
import DPPParser.parsers.ParsingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class FloatArgumentParserTest {

    private FloatArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new FloatArgumentParser();
    }

    @Test
    public void testParse_Integer_Pass() throws Exception {
        Float result = parser.parse("1");
        Float expected = 1f;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveFloatNumber_Pass() throws Exception {
        Float result = parser.parse("1.567");
        Float expected = 1.567f;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveNumberBoundary_Pass() throws Exception {
        String floatMaxValue = Float.MAX_VALUE + "";
        Float result = parser.parse(floatMaxValue);
        Float expected = Float.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeFloatNumber_Pass() throws Exception {
        Float result = parser.parse("-122");
        Float expected = -122f;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumberBoundary_Pass() throws Exception {
        String floatMinValue = Float.MIN_VALUE + "";
        Float result = parser.parse(floatMinValue);
        Float expected = Float.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_Letter_ThrowException() throws Exception {
        Float result = parser.parse("a");
    }


    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage_Pass() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as float");
    }

}