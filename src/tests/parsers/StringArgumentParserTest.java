package tests.parsers;

import DPPParser.parsers.StringArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StringArgumentParserTest {

    private StringArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new StringArgumentParser();
    }

    @Test
    public void testParse_SimpleString_Pass() {
        String result = parser.parse("Hello world");
        String expected = "Hello world";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParse_ComplexString_Pass() {
        String result = parser.parse("\tHello \n \"world\"");
        String expected = "\tHello \n \"world\"";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testGetErrorMessage_Pass() throws Exception {
        parser.parse("value");
        Assert.assertEquals(parser.getParseErrorMessage(), "");
    }
}