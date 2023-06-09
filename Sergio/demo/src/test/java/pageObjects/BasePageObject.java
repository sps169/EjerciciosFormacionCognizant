package pageObjects;

import config.Configuration;
import org.openqa.selenium.WebDriver;

public abstract class BasePageObject {
    //singleton
    public WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

}
