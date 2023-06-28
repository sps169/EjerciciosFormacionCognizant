package org.example.The_Internet_Exercises;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class Redirect_Link extends Parent_Page{
    public Redirect_Link() {
        super();
    }

    public void clickLink(){
        super.sleep();
        Actions actions = new Actions(super.driver);
        actions.keyDown(Keys.CONTROL)
                .click(super.getByXpath("//a[@id='redirect']"))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }

    public void catchUrl(){
        super.sleep();
        System.out.println("Redirected to " + super.driver.getCurrentUrl());
    }


}
