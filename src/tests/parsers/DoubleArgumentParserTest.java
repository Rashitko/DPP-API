package tests.parsers;

import DPPParser.parsers.DoubleArgumentParser;
import DPPParser.parsers.ParsingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DoubleArgumentParserTest {

    private DoubleArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new DoubleArgumentParser();
    }

    @Test
    public void testParse_Integer_Pass() throws Exception {
        Double result = parser.parse("1");
        Double expected = 1d;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveDoubleNumber_Pass() throws Exception {
        Double result = parser.parse("1.567");
        Double expected = 1.567d;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveNumberBoundary_Pass() throws Exception {
        String doubleMaxValue = Double.MAX_VALUE + "";
        Double result = parser.parse(doubleMaxValue);
        Double expected = Double.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeDoubleNumber_Pass() throws Exception {
        Double result = parser.parse("-122");
        Double expected = -122d;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumberBoundary_Pass() throws Exception {
        String doubleMinValue = Double.MIN_VALUE + "";
        Double result = parser.parse(doubleMinValue);
        Double expected = Double.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_Letter_ThrowException() throws Exception {
        Double result = parser.parse("a");
    }


    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage_Pass() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as double");
    }

}