package testScripts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.WindowPage;

import java.time.Duration;

public class WindowTest extends BaseTest{
    public WindowTest(String browser) {
        super(browser);
    }

    @Test
    public void test() {
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.leafground.com/window.xhtml");
        PageFactory.initElements(driver, WindowPage.class).openTabBlueButton.click();
        String baseWindow = driver.getWindowHandle();
        driver.getWindowHandles().forEach(e -> {
            if (!e.contentEquals(baseWindow) && driver.getWindowHandles().size() == 2)
                driver.switchTo().window(e);
        });
        DashboardPage page = PageFactory.initElements(driver, DashboardPage.class);
        page.checkBoxes.forEach(e -> {
            new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(200))
                    .ignoring(ElementNotInteractableException.class)
                    .until(ExpectedConditions.elementToBeClickable(e));
            e.click();
        });
        page.email.sendKeys("alexitto@cognizant.com");
        page.message.sendKeys("I don't know how to count up to 10. Please help this is urgent.");
        driver.close();
        driver.switchTo().window(baseWindow);
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        driver.close();
    }

    @Test
    public void test2() {
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.leafground.com/window.xhtml");
        PageFactory.initElements(driver, WindowPage.class).openWindowYellowButton.click();
        Assert.assertTrue(driver.getWindowHandles().size() > 1);
        String baseWindow = driver.getWindowHandle();
        driver.getWindowHandles().forEach(e -> {
            if (!e.contentEquals(baseWindow)) {
                driver.switchTo().window(e);
                driver.close();
            }
        });
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        driver.switchTo().window(baseWindow);
        driver.close();
    }

    @Test
    public void test3() {
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.leafground.com/window.xhtml");
        PageFactory.initElements(driver, WindowPage.class).openWindowPurpleButton.click();
        Assert.assertTrue(driver.getWindowHandles().size() > 1);
        String baseWindow = driver.getWindowHandle();
        System.out.println("The total number of openned tabs is " + (driver.getWindowHandles().size() - 1));
        driver.getWindowHandles().forEach(e -> {
            if (!e.contentEquals(baseWindow)) {
                driver.switchTo().window(e);
                driver.close();
            }
        });
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        driver.switchTo().window(baseWindow);
        driver.close();
    }

    @Test
    public void test4() {
        WebDriver driver = driverManager.getDriver();
        driver.get("https://www.leafground.com/window.xhtml");
        PageFactory.initElements(driver, WindowPage.class).openTabsDelayGreenButton.click();
        String baseWindow = driver.getWindowHandle();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.numberOfWindowsToBe(3));
        Assert.assertEquals(3, driver.getWindowHandles().size());
        driver.getWindowHandles().forEach(e -> {
            if (!e.contentEquals(baseWindow)) {
                driver.switchTo().window(e);
                System.out.println("Closing tab: " + driver.getTitle());
                driver.close();
            }
        });
        Assert.assertEquals(driver.getWindowHandles().size(), 1);
        driver.switchTo().window(baseWindow);
        driver.close();
    }
}
