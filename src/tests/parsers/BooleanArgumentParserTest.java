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
    public void testParseTrue() throws Exception {
        Boolean result = parser.parse("true");
        Assert.assertTrue(result == true);
    }

    @Test
    public void testParseFalse() throws Exception {
        Boolean result = parser.parse("false");
        Assert.assertTrue(result == false);
    }

    @Test
    public void testParseNumber() throws Exception {
        Boolean result = parser.parse("1");
        Assert.assertTrue(result == false);
    }

    @Test
    public void testParseStringDifferentFromTrue() throws Exception {
        Boolean result = parser.parse("yes");
        Assert.assertTrue(result == false);
    }

    public void testGetErrorMessage() throws Exception {
        parser.parse("value");
        Assert.assertEquals(parser.getParseErrorMessage(), "");
    }
}