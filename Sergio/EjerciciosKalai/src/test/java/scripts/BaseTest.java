package scripts;

import driverManagement.DriverFactory;
import driverManagement.DriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import pages.DashboardPage;
import pages.WindowPage;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public abstract class BaseTest {

    public DriverManager driverManager;

    public BaseTest(String browser) {
        this.driverManager = DriverFactory.valueOf(browser).getDriverManager();
    }
    @Parameterized.Parameters
    public static Collection<String> data() {
        return List.of(
                "CHROME",
                "EDGE"
        );
    }

    @After
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
