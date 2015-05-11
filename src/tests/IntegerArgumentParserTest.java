package tests;

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
    public void test_PositiveNumber_OK() throws Exception {
        Integer result = parser.parse("1");
        Integer expected = 1;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void test_NegativeNumber_OK() throws Exception {
        Integer result = parser.parse("-122");
        Integer expected = -122;
        Assert.assertEquals(result, expected);
    }

    @Test(expectedExceptions = ParsingException.class)
    public void test_Letter_ThrowException() throws Exception {
        Integer result = parser.parse("a");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void test_OutOfRange_ThrowException() throws Exception {
        Integer result = parser.parse("999999999999999999999");
    }

    @Test(expectedExceptions = ParsingException.class)
    public void test_FloatNumber_ThrowException() throws Exception {
        Integer result = parser.parse("5.5");
    }

}