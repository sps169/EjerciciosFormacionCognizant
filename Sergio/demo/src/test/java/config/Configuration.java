package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuration {
    public static WebDriver getDriver() {
        //todo multibrowser capabilities
        return new ChromeDriver();
    }
}
