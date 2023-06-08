package org.example.The_Internet_Exercises;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Set;

public class Multiple_Windows extends Parent_Page{
    public Multiple_Windows() {
        super();
    }

    public void clickHere(){
        super.sleep();
        super.getByXpath("//a[@href=\"/windows/new\"]").click();
    }
    public void catchText(){
        super.sleep();
        super.changeWindow();
        System.out.println("The text is: " + super.getByXpath("//h3").getText());

    }
}
