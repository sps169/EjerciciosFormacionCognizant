package org.proyecto1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestProyecto1 {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    @Test
    public void test1() {
        Alerts alerts = new Alerts(driver);
        alerts.jsAlert();
        alerts.jsConfirm();
        alerts.jsPrompt();
    }

}

