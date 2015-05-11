package tests.parsers;

import DPPParser.parsers.LongArgumentParser;
import DPPParser.parsers.ParsingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class LongArgumentParserTest {

    private LongArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new LongArgumentParser();
    }

    @Test
    public void testParse_PositiveNumber_Pass() throws Exception {
        Long result = parser.parse("15");
        Long expected = 15L;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveNumberBoundary_Pass() throws Exception {
        String longMaxValue = Long.MAX_VALUE + "";
        Long result = parser.parse(longMaxValue);
        Long expected = Long.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumber_Pass() throws Exception {
        Long result = parser.parse("-122");
        Long expected = -122L;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumberBoundary_Pass() throws Exception {
        String longMinValue = Long.MIN_VALUE + "";
        Long result = parser.parse(longMinValue);
        Long expected = Long.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_Letter_ThrowException() throws Exception {
        Long result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_OutOfRange_ThrowException() throws Exception {
        Long result = parser.parse("10000000000000000000000000000000");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_FloatNumber_ThrowException() throws Exception {
        Long result = parser.parse("-5.5");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage_Pass() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as long");
    }

}