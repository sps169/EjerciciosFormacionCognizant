package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EjercicioExtra5 implements Ejercicio{

    private WebDriver driver = new ChromeDriver();
    private static EjercicioExtra5 instance;
    private final String LINK = "https://the-internet.herokuapp.com";

    private EjercicioExtra5() {

    }

    public static EjercicioExtra5 getInstance() {
        if (instance == null)
            instance = new EjercicioExtra5();
        return instance;
    }
    @Override
    public void run() {
        driver.get(LINK);
        driver.findElement(By.linkText("Nested Frames")).click();
        waitLoad(By.tagName("frameset"));
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.quit();
    }

    public void waitLoad(By locator) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(3),
                Duration.ofMillis(500)
        );
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
