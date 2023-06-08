package pageObjects;

import config.Configuration;
import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {
    //singleton
    private static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null)
            driver = Configuration.getDriver();
        return driver;
    }
}
