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
    public void testParseSimpleString() {
        String result = parser.parse("Hello world");
        String expected = "Hello world";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testParseComplexString() {
        String result = parser.parse("\tHello \n \"world\"");
        String expected = "\tHello \n \"world\"";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        parser.parse("value");
        Assert.assertEquals(parser.getParseErrorMessage(), "");
    }
}