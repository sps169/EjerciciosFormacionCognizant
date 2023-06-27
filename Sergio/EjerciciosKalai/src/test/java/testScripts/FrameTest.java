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
    public void testCountFrames() {
        WebDriver driver = driverManager.getDriver();
        driver.get(FramePage.LINK);
        Assert.assertEquals(4, PageFactory.initElements(driver, FramePage.class).countiFrames());

    }
}
