package tests;

import DPPParser.options.Option;
import DPPParser.options.OptionsList;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class OptionsListTest {
    Option first;
    Option second;
    private OptionsList optionList;

    @BeforeClass
    public void initialize() {
        optionList = new OptionsList();
        first = new Option.Builder("s").addLongSwitch("long").build();
        second = new Option.Builder("u").addLongSwitch("longer").build();
    }

    @Test
    public void testAddFirst() {

        boolean result = optionList.add(first);
        Assert.assertTrue(result);
        Assert.assertEquals(optionList.getSize(), 1);
    }

    @Test(dependsOnMethods = {"testAddFirst"})
    public void testAddTheSameOption() {
        boolean result = optionList.add(first);
        Assert.assertFalse(result);
        Assert.assertEquals(optionList.getSize(), 1);
    }

    @Test(dependsOnMethods = {"testAddTheSameOption"})
    public void testAddSecondOption() {
        boolean result = optionList.add(second);
        Assert.assertTrue(result);
        Assert.assertEquals(optionList.getSize(), 2);
    }

    @Test(dependsOnMethods = {"testAddSecondOption"})
    public void testFindOptionByLongSwitchFound() {
        Option returnedOption = optionList.findOptionByLongSwitch("longer");
        Assert.assertEquals(returnedOption, second);
    }

    @Test(dependsOnMethods = {"testAddSecondOption"})
    public void testFindOptionByLongSwitchNotFound() {
        Option returnedOption = optionList.findOptionByLongSwitch("notInTheList");
        Assert.assertNull(returnedOption);
    }

    @Test(dependsOnMethods = {"testAddSecondOption"})
    public void testFindOptionByShortSwitchFound() {
        Option returnedOption = optionList.findOptionByShortSwitch("s");
        Assert.assertEquals(returnedOption, first);
    }

    @Test(dependsOnMethods = {"testAddSecondOption"})
    public void testFindOptionByShortSwitchNotFound() {
        Option returnedOption = optionList.findOptionByShortSwitch("b");
        Assert.assertNull(returnedOption);
    }
}