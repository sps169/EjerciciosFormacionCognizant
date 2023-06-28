package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejercicio3 {
    private static Ejercicio3 instance;

    private static final String LINK = "https://the-internet.herokuapp.com/";
    private WebDriver driver = new ChromeDriver();

    private Ejercicio3()
    {

    }

    public static Ejercicio3 getInstance() {
        if (instance == null) {
            instance = new Ejercicio3();
        }
        return instance;
    }

    public void run() {
        driver.get(LINK);
        String newLink = driver.findElement(By.cssSelector("a[href$=\"login\"]"))
                .getAttribute("href");
        driver.get(newLink);
        login();
        waitAndQuit();
    }

    public void login() {
        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("input#password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.tagName("form")).submit();
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
