package testScripts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.FramePage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FrameTest extends BaseTest{

    public FrameTest(String browser) {
        super(browser);
    }

    @Test
    public void clickInsideFrame() {
        WebDriver driver = driverManager.getDriver();
        driver.get(FramePage.LINK);
        FramePage page = PageFactory.initElements(driver, FramePage.class);
        String beforeClick = page.getOrangeButtonText();
        page.clickOrangeButton();
        String afterClick = page.getOrangeButtonText();
        Assert.assertNotEquals(beforeClick, afterClick);
    }

    @Test
    public void clickInsideNestedFrame() {
        WebDriver driver = driverManager.getDriver();
        driver.get(FramePage.LINK);
        FramePage page = PageFactory.initElements(driver, FramePage.class);
        String beforeClick = page.getPurpleButtonText();
        String afterClick = page.clickPurpleButton();
        Assert.assertNotEquals(beforeClick, afterClick);
    }

    @Test
    public void testCountFrames() {
        WebDriver driver = driverManager.getDriver();
        driver.get(FramePage.LINK);
        Assert.assertEquals(4, PageFactory.initElements(driver, FramePage.class).countiFrames());
    }
}
