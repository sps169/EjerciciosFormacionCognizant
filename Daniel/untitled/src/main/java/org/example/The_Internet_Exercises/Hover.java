package org.example.The_Internet_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Hover extends Parent_Page{
    public Hover() {
        super();
    }

    private void hover(WebElement element){
        super.sleep();
        Actions action = new Actions(super.driver);
        action.moveToElement(element).perform();
    }

    public void getAllDivs(){
        int cont =  super.driver.findElements(By.xpath("//div[@class='figure']")).size();
        for (int i = 1; i <= cont; i++){
            WebElement div = super.getByXpath("//div[@class='figure'][" + i +"]");
            hover(div);
            catchText(i);
        }
    }

    private void catchText(int div){
        super.sleep();
        System.out.println("Text catched: " + super.getByXpath("//div[@class='figure'][" + div +"]//h5").getText());
    }
}
