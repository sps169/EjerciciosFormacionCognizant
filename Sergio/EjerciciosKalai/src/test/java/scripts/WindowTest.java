package scripts;

import org.junit.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
        driver.close();
    }

    @Test
    public void test2() {
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
        driver.close();
    }
}
