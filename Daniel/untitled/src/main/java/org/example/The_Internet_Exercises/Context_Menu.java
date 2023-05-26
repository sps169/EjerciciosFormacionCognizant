package org.example.The_Internet_Exercises;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

public class Context_Menu extends Parent_Page{
    Alert alert;
    Actions action;
    public Context_Menu() {
        super();
        action = new Actions(super.driver);
    }

    public void rightClick(){
        super.sleep();
        action.contextClick(super.getByXpath("//div[@id='hot-spot']")).perform();
    }

    public void manageAlert(){
        super.sleep();
        this.alert = super.driver.switchTo().alert();
        System.out.println(this.alert.getText());
        this.alert.accept();
    }

}
