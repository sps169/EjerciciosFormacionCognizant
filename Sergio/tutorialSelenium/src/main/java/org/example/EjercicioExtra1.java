package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EjercicioExtra1 {
    private static EjercicioExtra1 instance;

    private static final String LINK = "https://rahulshettyacademy.com/AutomationPractice/";
    private WebDriver driver = new ChromeDriver();

    private EjercicioExtra1()
    {

    }

    public static EjercicioExtra1 getInstance() {
        if (instance == null) {
            instance = new EjercicioExtra1();
        }
        return instance;
    }

    public void run() {
        driver.get(LINK);
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#checkBoxOption1"));
        checkbox1.click();
        if (checkbox1.isSelected())
            System.out.println("First checkbox correctly selected");
        else
            System.err.println("Something went wrong while selecting the first checkbox");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkbox1.click();
        if (!checkbox1.isSelected())
            System.out.println("First checkbox correctly deselected");
        else
            System.err.println("Something went wrong while deselecting the first checkbox");
        long selectedCheckboxes = driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).stream().filter(WebElement::isSelected).count();
        System.out.println("There are " + selectedCheckboxes + " selected checkboxes");
    }
}
