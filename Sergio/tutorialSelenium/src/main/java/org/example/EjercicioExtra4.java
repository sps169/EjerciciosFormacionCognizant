package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;

public class EjercicioExtra4 implements Ejercicio{
    private static EjercicioExtra4 instance;
    private WebDriver driver = new ChromeDriver();
    private final String LINK = "https://the-internet.herokuapp.com/";

    private EjercicioExtra4 () {

    }

    public static EjercicioExtra4 getInstance() {
        if (instance == null)
            instance = new EjercicioExtra4();
        return instance;
    }
    @Override
    public void run() {
        driver.get(LINK);
        driver.findElement(By.linkText("Multiple Windows")).click();
        By linkPath = By.xpath("//a[@href=\"/windows/new\"]");
        waitLoad(linkPath);
        driver.findElement(linkPath).click();
        Iterator<String> it = driver.getWindowHandles().iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
        waitLoad(By.tagName("h3"));
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(parent);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }

    public void waitLoad(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(5),
                Duration.ofMillis(100)
        );
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }
}
