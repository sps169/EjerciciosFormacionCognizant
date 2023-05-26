package org.example.The_Internet_Exercises;

import org.openqa.selenium.Alert;

public class Javascript_Alerts extends Parent_Page{
    Alert alert;
    public Javascript_Alerts() {
        super();
    }

    public void acceptAlert(){
        super.sleep();
        super.getByXpath("//button[@onclick=\"jsAlert()\"]").click();
        this.alert = super.driver.switchTo().alert();
        alert.accept();
    }

    public void okConfirm(String option){
        super.sleep();
        super.getByXpath("//button[@onclick=\"jsConfirm()\"]").click();
        this.alert = super.driver.switchTo().alert();
        if (option.equals("Ok")) alert.accept();
        else if (option.equals("Cancel")) alert.dismiss();
    }

    public void inputPrompt(){
        super.sleep();
        super.getByXpath("//button[@onclick=\"jsPrompt()\"]").click();
        this.alert = super.driver.switchTo().alert();
        alert.sendKeys("Testing input");
        alert.accept();
    }

    public void catchResult(){
        super.sleep();
        System.out.println(super.getByXpath("//p[@id='result']").getText());
    }
}
