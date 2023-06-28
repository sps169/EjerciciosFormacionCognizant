package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import javax.lang.model.element.Element;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class EjercicioExtra3 implements Ejercicio{

    public WebDriver driver = new ChromeDriver();

    public final String LINK = "https://rahulshettyacademy.com/loginpagePractise/";

    public static EjercicioExtra3 instance;

    private EjercicioExtra3() {

    }

    public static EjercicioExtra3 getInstance() {
        if (instance == null)
            instance = new EjercicioExtra3();
        return instance;
    }

    public void run() {
        driver.get(LINK);
        driver.findElement(By.id("username")).sendKeys(
                driver.findElement(By.xpath("(//p[@class='text-center text-white']//i)[1]")).getText()
        );
        driver.findElement(By.id("password")).sendKeys(
                driver.findElement(By.xpath("(//p[@class='text-center text-white']//i)[2]")).getText()
        );
        driver.findElement(By.xpath("//input[@value=\"user\"]")).click();
        waitLocator(By.id("okayBtn"));
        driver.findElement(By.id("okayBtn")).click();
        waitLocator(By.cssSelector("select.form-control"));
        new Select(driver.findElement(By.cssSelector("select.form-control"))).selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
        waitList();
        List<WebElement> itemButtons = driver.findElements(By.cssSelector("button.btn.btn-info"));
        System.out.println(itemButtons.size());
        itemButtons.forEach(WebElement::click);
        driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();
    }

    public void waitLocator(By elementLocator) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10),
                Duration.ofMillis(100)
        );
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    public void waitList() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Wait<WebDriver> wait = new FluentWait<>(driver);
        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(By.cssSelector("button.btn.btn-info"));
                if (elements.size() > 0 && elements.stream().allMatch(WebElement::isDisplayed))
                    return Boolean.TRUE;
                else
                    return Boolean.FALSE;
            }
        });
    }


}
