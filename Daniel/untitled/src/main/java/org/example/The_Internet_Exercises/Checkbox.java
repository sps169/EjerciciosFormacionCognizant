package org.example.The_Internet_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Checkbox extends Parent_Page{
    WebElement checkbox;
    public Checkbox() {
        super();
    }

    public void interactCheckbox(int option){
        super.sleep();
        this.checkbox = super.getByXpath("//form[@id=\"checkboxes\"]/input[" + option + "]");
        this.checkbox.click();
    }

    public int countCheckboxes(){
        return super.driver.findElements(By.xpath("//form[@id=\"checkboxes\"]/input")).size();
    }

    public void isSelected(){
        super.sleep();
        if (this.checkbox.isSelected())
            System.out.println("Correct. Checkbox is selected!");
        else
            System.out.println("Error. Checkbox is not selected!");
    }

    public void isNotSelected(){
        super.sleep();
        if (!this.checkbox.isSelected())
            System.out.println("Correct. Checkbox is not selected!");
        else {
            System.out.println("Error. Checkbox is selected!");
        }
    }
}
