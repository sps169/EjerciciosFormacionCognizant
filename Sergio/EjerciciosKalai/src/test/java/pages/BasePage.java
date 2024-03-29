package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public String link;

    public BasePage (WebDriver driver, String link) {
        this.driver = driver;
        this.link = link;
    }
}
