package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ejercicio2 {
    private static Ejercicio2 instance;
    private static final String LINK = "https://the-internet.herokuapp.com/";
    private WebDriver driver = new ChromeDriver();

    private Ejercicio2 () {

    }

    public static Ejercicio2 getInstance() {
        if (instance == null)
            instance = new Ejercicio2();
        return instance;
    }
    public void run() {
        driver.get(LINK);
        String dropdownLink = driver.findElement(By.linkText("Dropdown")).getAttribute("href");
        driver.get(dropdownLink);
        Select dropdown = new Select(driver.findElement(By.cssSelector("select#dropdown")));
        dropdown.selectByIndex(((int)(Math.random() * 2 + 1)));
        dropdown.getAllSelectedOptions().forEach(e -> System.out.println(e.getText()));
        waitAndQuit();
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
