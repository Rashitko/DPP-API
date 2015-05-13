package tests.parsers;

import DPPParser.parsers.ByteArgumentParser;
import DPPParser.parsers.ParsingException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ByteArgumentParserTest {

    private ByteArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new ByteArgumentParser();
    }

    @Test
    public void testParsePositiveNumber() throws Exception {
        Byte result = parser.parse("15");
        Byte expected = 15;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParsePositiveNumberBoundary() throws Exception {
        String byteMaxValue = Byte.MAX_VALUE + "";
        Byte result = parser.parse(byteMaxValue);
        Byte expected = Byte.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseNegativeNumber() throws Exception {
        Byte result = parser.parse("-80");
        Byte expected = -80;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseNegativeNumberBoundary() throws Exception {
        String byteMinValue = Byte.MIN_VALUE + "";
        Byte result = parser.parse(byteMinValue);
        Byte expected = Byte.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseLetter() throws Exception {
        Byte result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseOutOfRange() throws Exception {
        Byte result = parser.parse("-129");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParseFloatNumber() throws Exception {
        Byte result = parser.parse("-5.5");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testGetErrorMessage() throws Exception {
        parser.parse("a");
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as byte");
    }

}