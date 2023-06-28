package org.example.The_Internet_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Nested_Frames extends Parent_Page{
    WebElement mainFrame;
    public Nested_Frames() {
        super();
    }
    public void switchToFirstFrame(){
        super.sleep();
        this.mainFrame = super.getByXpath("//frame[@name='frame-top']");
        switchToFrame(mainFrame);

    }
    private void switchToFrame(WebElement frame){
        super.driver.switchTo().frame(frame);
    }
    public void recursiveSearch(){
        super.sleep();
        List<WebElement> frames = super.driver.findElements(By.xpath("//frameset[@name='frameset-middle']//frame"));
        System.out.println(frames.size());
        for(WebElement frame : frames){
            switchToFrame(frame);
            WebElement container = super.getByXpath("//body");
            if (container.getText().equals("")){
                container =  super.getByXpath("//div[@id='content']");
            }
            super.sleep();
            System.out.println("Captured text: " + container.getText());
            super.driver.switchTo().defaultContent();
            switchToFrame(mainFrame);
        }
    }
}
