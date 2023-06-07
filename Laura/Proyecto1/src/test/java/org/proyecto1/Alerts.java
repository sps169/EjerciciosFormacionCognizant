package org.proyecto1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.Duration;

public class Alerts {
    private WebDriver driver;
    private Alert alert;
    public Alerts(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Navegar a la página web
        this.driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    public void jsAlert() {
        try{
            // Hacer clic en el botón "JS Alert"
            WebElement jsBotton =  driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
            jsBotton.click();
            // Cambiar al cuadro de alerta
            alert = driver.switchTo().alert();
            // Aceptar la alerta
            alert.accept();
            String result = "You successfully clicked an alert";
            catchResult(result);
        }catch (Exception e){
            System.out.println("Error: " + e);

        }
    }

    public void jsConfirm(){
        try{
            // Hacer clic en el botón "JS Confirm"
            WebElement jsBotton = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
            jsBotton.click();
            // Cambiar al cuadro de alerta
            alert = driver.switchTo().alert();
            // Rechazar la alerta
            alert.dismiss();
            String result = "You clicked: Cancel";
            catchResult(result);
        }
        catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void jsPrompt(){
        try {
            // Hacer clic en el botón "JS Prompt"
            WebElement jsBotton = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
            jsBotton.click();
            // Cambiar al cuadro de alerta
            alert = driver.switchTo().alert();
            // Ingresar texto en la alerta
            alert.sendKeys("Hello, Selenium!");
            // Aceptar la alerta
            alert.accept();
            System.out.println("Patata");
            String result = "You entered: Hello, Selenium!";
            catchResult(result);
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }

    public void catchResult(String expected){
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result,expected);
    }
}
