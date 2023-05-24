package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EjercicioExtra2 {
    private static EjercicioExtra2 instance;

    private static final String LINK = "https://rahulshettyacademy.com/angularpractice/";
    private WebDriver driver = new ChromeDriver();

    private EjercicioExtra2()
    {

    }

    public static EjercicioExtra2 getInstance() {
        if (instance == null) {
            instance = new EjercicioExtra2();
        }
        return instance;
    }

    public void run() {
        driver.get(LINK);
        driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("Student");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("student@email.com");
        driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]")).sendKeys("Password123$");
        driver.findElement(By.xpath("//input[@id=\"exampleCheck1\"]")).click();
        new Select(driver.findElement(By.xpath("//select[@id=\"exampleFormControlSelect1\"]")))
                .selectByVisibleText("Male");
        driver.findElement(By.xpath("//input[@id=\"inlineRadio1\"]")).click();
        driver.findElement(By.xpath("//input[@type=\"date\"]")).sendKeys("21122000");
        driver.findElement(By.cssSelector("input.btn.btn-success")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).getText());


    }
}
