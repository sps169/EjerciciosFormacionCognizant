package org.example.The_Internet_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Parent_Page {
    WebDriver driver;
    String url;
    int sleepTime;
    public Parent_Page() {
        this.driver = new ChromeDriver();
        this.url =  "https://the-internet.herokuapp.com/";
        this.sleepTime = 500;
        driverSettings();
    }
    public void driverSettings(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
        this.driver.manage().window().maximize();
        this.driver.get(this.url);
    }
    public void findPage(String text){
        this.getByXpath("//*[text()=\"" + text + "\"]").click();
    }

    public WebElement getByXpath(String xpath){
        return this.driver.findElement(By.xpath(xpath));
    }

    public void sleep(){
        try {Thread.sleep(this.sleepTime);} catch (InterruptedException ignored){}
    }
    public void quit(){
        this.driver.quit();
    }

    public void changeWindow(){
        this.sleep();
        Set<String> windows = this.driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        it.next(); // Skips first window
        String childWindow = it.next();
        this.driver.switchTo().window(childWindow);
    }

    public void closeWindow() {
        this.sleep();
        this.changeWindow();
        this.driver.close();
    }
}
