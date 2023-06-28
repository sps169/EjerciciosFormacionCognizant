package testScripts;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AlertPage;

public class AlertTest extends BaseTest{
    public AlertTest(String browser) {
        super(browser);
    }

    @Test
    public void whiteAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertEquals("", page.getWhiteAlertText());
        page.alertAction(page.whiteAlertButton);
        Assert.assertEquals("You have successfully clicked an alert", page.getWhiteAlertText());
    }

    @Test
    public void yellowAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertEquals("", page.getYellowAlertText());
        page.alertAction(page.yellowAlertButton);
        Assert.assertEquals("User Clicked : OK", page.getYellowAlertText());
    }

    @Test
    public void blueAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertFalse(page.blueAlert.isDisplayed());
        page.embeddedAlertOpen(page.blueAlert, page.blueAlertButton);
        Assert.assertTrue(page.blueAlert.isDisplayed());
        page.embeddedAlertDismiss(page.blueAlert, page.blueAlertDismissButton);
        Assert.assertFalse(page.blueAlert.isDisplayed());
    }

    @Ignore //bug in firefox todo test in edge
    @Test //todo merge with blueAlertTest
    public void purpleAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertFalse(page.purpleAlert.isDisplayed());
        page.embeddedAlertOpen(page.purpleAlert, page.purpleAlertButton);
        Assert.assertTrue(page.purpleAlert.isDisplayed());
        page.embeddedAlertDismiss(page.purpleAlert, page.purpleAlertDismiss);
        Assert.assertFalse(page.purpleAlert.isDisplayed());
    }

    @Test
    public void greenAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertEquals("", page.getGreenAlertText());
        String keys = "Test!";
        page.alertAction(page.greenAlertButton, keys);
        Assert.assertEquals("User entered name as: " + keys, page.getGreenAlertText());
    }

    @Test
    public void redAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertFalse(page.redAlert.isDisplayed());
        page.embeddedAlertOpen(page.redAlert, page.redAlertButton);
        Assert.assertTrue(page.redAlert.isDisplayed());
        page.embeddedAlertDismiss(page.redAlert, page.redAlertYes);
        Assert.assertFalse(page.redAlert.isDisplayed());
        page.embeddedAlertOpen(page.redAlert, page.redAlertButton);
        Assert.assertTrue(page.redAlert.isDisplayed());
        page.embeddedAlertDismiss(page.redAlert, page.redAlertNo);
        Assert.assertFalse(page.redAlert.isDisplayed());
    }

    @Ignore //bug in firefox (same as purple) todo test in edge
    @Test
    public void minMaxAlertTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(AlertPage.LINK);
        AlertPage page = PageFactory.initElements(driver, AlertPage.class);
        Assert.assertFalse(page.whiteMinMaxAlert.isDisplayed());
        page.embeddedAlertOpen(page.whiteMinMaxAlert, page.whiteMinMaxButton);
        Assert.assertTrue(page.whiteMinMaxAlert.isDisplayed());
        //todo test minimize & maximize
        page.embeddedAlertDismiss(page.whiteMinMaxAlert, page.minMaxAlertCloseButton);
        Assert.assertFalse(page.whiteMinMaxAlert.isDisplayed());
    }
}
