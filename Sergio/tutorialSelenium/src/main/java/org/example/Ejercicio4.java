package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Ejercicio4 implements Ejercicio{

    private WebDriver driver = new ChromeDriver();

    private final String LINK = "https://the-internet.herokuapp.com/";

    private static Ejercicio4 instance;

    private Ejercicio4() {

    }

    public static Ejercicio4 getInstance() {
        if (instance == null)
            instance = new Ejercicio4();
        return instance;
    }
    @Override
    public void run() {
        driver.get(LINK);
        driver.findElement(By.linkText("Hovers")).click();
        waitLoad(By.tagName("img"));
        WebElement figure = driver.findElement(By.xpath("//div[@class='figure' and .//h5/text()='name: user1']"));
        waitElement(figure);
        new Actions(driver).moveToElement(figure).perform();
        WebElement name = figure.findElement(By.tagName("h5"));
        if (name.isDisplayed())
            System.out.println(name.getText());
        WebElement link = figure.findElement(By.linkText("View profile"));
        if (link.isDisplayed())
            System.out.println(link.getAttribute("href"));
        waitAndQuit();
    }

    public void waitLoad(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(5),
                Duration.ofMillis(100)
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    public void waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(5),
                Duration.ofMillis(100)
        );
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAndQuit() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
