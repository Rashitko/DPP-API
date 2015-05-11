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
    public void testParse_PositiveNumber_Pass() throws Exception {
        Byte result = parser.parse("15");
        Byte expected = 15;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_PositiveNumberBoundary_Pass() throws Exception {
        String byteMaxValue = Byte.MAX_VALUE + "";
        Byte result = parser.parse(byteMaxValue);
        Byte expected = Byte.MAX_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumber_Pass() throws Exception {
        Byte result = parser.parse("-80");
        Byte expected = -80;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_NegativeNumberBoundary_Pass() throws Exception {
        String byteMinValue = Byte.MIN_VALUE + "";
        Byte result = parser.parse(byteMinValue);
        Byte expected = Byte.MIN_VALUE;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_Letter_ThrowException() throws Exception {
        Byte result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_OutOfRange_ThrowException() throws Exception {
        Byte result = parser.parse("-129");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void testParse_FloatNumber_ThrowException() throws Exception {
        Byte result = parser.parse("-5.5");
    }

    @Test
    public void testGetErrorMessage_Pass() {
        try {
            parser.parse("a");
        } catch (ParsingException e) {
            // ignore the exception on purpose
        }
        Assert.assertEquals(parser.getParseErrorMessage(), "a cannot be parsed as byte");
    }

}