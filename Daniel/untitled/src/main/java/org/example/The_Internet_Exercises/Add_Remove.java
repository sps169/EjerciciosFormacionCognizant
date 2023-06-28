package org.example.The_Internet_Exercises;

public class Add_Remove extends Parent_Page{
    public Add_Remove() {
        super();
    }

    public void add_element(){
        super.sleep();
        super.getByXpath("//*[@onclick=\"addElement()\"]").click();
    }

    public void remove_element(){
        super.sleep();
        super.getByXpath("//*[@id=\"elements\"]/button[1]").click();
    }
}
