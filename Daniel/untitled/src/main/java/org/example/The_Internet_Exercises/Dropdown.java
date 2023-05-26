package org.example.The_Internet_Exercises;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends Parent_Page{

    Select select;
    public Dropdown() {
        super();
    }

    public void selectDropdown(){
        super.sleep();
        this.select = new Select(super.getByXpath("//select[@id='dropdown']"));
    }

    public Boolean selectOption(int option){
        super.sleep();
        try {
            this.select.selectByIndex(option);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public int getOptionsSize(){
        return this.driver.findElements(By.xpath("//select[@id='dropdown']/option")).size();
    }

    public void checkSelected(String expected){
        super.sleep();
        String actual = this.select.getFirstSelectedOption().getText(),
                result = "Expected " + expected +" got " + actual + ". ";
        result += actual.equals(expected) ? "CORRECT!": "ERROR";
        System.out.println(result);
        super.sleep();
    }
}
