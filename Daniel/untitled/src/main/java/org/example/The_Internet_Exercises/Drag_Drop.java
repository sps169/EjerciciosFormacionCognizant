package org.example.The_Internet_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Drag_Drop extends Parent_Page{
    Actions actions;
    WebElement a, b;

    public Drag_Drop() {
        super();
        this.actions = new Actions(super.driver);
    }

    public void dragAndDrop(){
        super.sleep();
        this.a = super.getByXpath("//div[@id=\"column-a\"]");
        this.b = super.getByXpath("//div[@id=\"column-b\"]");

        // direct way
        this.actions.dragAndDrop(a,b).build().perform();
        super.sleep();
        // step by step way
        this.actions = actions.clickAndHold(a).moveToElement(b);
        this.actions = actions.release(b);
        this.actions.build().perform();
    }

    public void checkResult(String expected){
        super.sleep();
        String actual = super.getByXpath("//div[@id=\"column-b\"]/header").getText();
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
