package org.proyecto1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Parent_Page {
    //Variables
    WebDriver driver;
    String url;
    int sleepTime;

    //Constructor
    public Parent_Page() {
        this.driver = new ChromeDriver();
        this.url = "https://www.demoblaze.com/";
        this.sleepTime = 500;
        driverSettings();
    }

    public void driverSettings(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
        this.driver.manage().window().maximize();
        this.driver.get(this.url);
    }
    public WebElement getByXpath(String xpath){
        return this.driver.findElement(By.xpath(xpath));
    }

    public void sleep(){
        try {
            Thread.sleep(this.sleepTime);
        }
        catch (InterruptedException ignored){
        }
    }
    public void quit(){
        this.driver.quit();
    }
}
