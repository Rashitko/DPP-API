package tests.parsers;


import DPPParser.parsers.BooleanArgumentParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BooleanArgumentParserTest {

    private BooleanArgumentParser parser;

    @BeforeClass
    public void initialize() {
        parser = new BooleanArgumentParser();
    }

    @Test
    public void testParse_True_Pass() throws Exception {
        Boolean result = parser.parse("true");
        Assert.assertTrue(result == true);
    }

    @Test
    public void testParse_False_Pass() throws Exception {
        Boolean result = parser.parse("false");
        Assert.assertTrue(result == false);
    }

    @Test
    public void testParse_Number_Pass() throws Exception {
        Boolean result = parser.parse("1");
        Assert.assertTrue(result == false);
    }

    @Test
    public void testParse_StringDifferentFromTrue_Pass() throws Exception {
        Boolean result = parser.parse("yes");
        Assert.assertTrue(result == false);
    }

    public void testGetErrorMessage_Pass() throws Exception {
        parser.parse("value");
        Assert.assertEquals(parser.getParseErrorMessage(), "value cannot be parsed as boolean");
    }
}