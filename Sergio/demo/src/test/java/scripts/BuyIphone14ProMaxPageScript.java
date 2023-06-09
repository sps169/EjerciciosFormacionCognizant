package scripts;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BuyIphonePage;
import pageObjects.FrontPage;
import pageObjects.SelectIphone14ProOptionsPage;
import pageObjects.StorePage;

import java.time.Duration;

public class BuyIphone14ProMaxPageScript {
    public WebDriver driver;

    @BeforeSuite
    public void setDriver() {
        driver = Configuration.getDriver();
    }

    @BeforeTest
    public void maximize() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(200));
    }

    @Test
    public void buyIphone14ProMax() {
        driver.get(FrontPage.LINK);
        FrontPage frontPage = PageFactory.initElements(driver, FrontPage.class);
        frontPage.navToStore();
        StorePage storePage = PageFactory.initElements(driver, StorePage.class);
        storePage.navToIphoneLink();
        BuyIphonePage buyIphonePage = PageFactory.initElements(driver, BuyIphonePage.class);
        buyIphonePage.selectIphone14ProMax();
        SelectIphone14ProOptionsPage optionsPage = PageFactory.initElements(driver, SelectIphone14ProOptionsPage.class);
        optionsPage.selectModelPreferences();
    }

    @AfterTest
    public void waitAndQuit() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.quit();
    }

}
