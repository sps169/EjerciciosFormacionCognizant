package org.example.The_Internet_Exercises;

import org.openqa.selenium.WebElement;


public class Form_Authentication extends Parent_Page{
    String username, password;
    public Form_Authentication() {
        super();
        this.username = "";
        this.password = "";
    }

    public void findUsername(){
        this.username = super.getByXpath("//h4/em[1]").getText();
    }

    public void findPassword(){
        this.password = super.getByXpath("//h4/em[2]").getText();
    }

    public void enterField(String field){
        super.sleep();
        WebElement input = super.getByXpath("//input[@id=\"" + field + "\"]");
        switch (field){
            case "username":
                input.sendKeys(this.username);
                break;
            case "password":
                input.sendKeys(this.password);
                break;
        }
    }

    public void submit(){
        super.sleep();
        super.getByXpath("//button[@type=\"submit\"]").click();
    }

    public void checkResult(){
        super.sleep();
        String result = super.getByXpath("//div[@id =\"flash\"]").getText().split("!")[0];
        switch (result){
            case "You logged into a secure area":
                System.out.println("Correct login");
                break;
            case "Your username is invalid":
                System.out.println("Incorrect login");
                break;
        }
    }
}
