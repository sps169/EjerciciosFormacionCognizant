package org.proyecto1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ChooseProduct extends Parent_Page{
    //Variables
    WebElement chooseCategories;
    WebElement product;
    WebElement button;

    public ChooseProduct(){
        super();
        this.chooseCategories = getByXpath("(//a[normalize-space()='Laptops'])[1]");
    }

    public void clickCategory(){
        chooseCategories.click();
    }
    public void clickProduct(){
        product = getByXpath("(//a[normalize-space()='MacBook Pro'])[1]");
        product.click();
    }

    public void addProductToCart(){
        button = getByXpath("(//a[normalize-space()='Add to cart'])[1]");
        button.click();
    }

    public void clickCart(){
        chooseCategories = getByXpath("(//a[normalize-space()='Cart'])[1]");
        chooseCategories.click();
        sleep();
        button = getByXpath("(//button[normalize-space()='Place Order'])[1]");
        button.click();
        sleep();
    }

    public void payProduct(){
        product = getByXpath("(//div[@role='document'])[3]");
        List<WebElement> payOrder = product.findElements(By.tagName("input"));
        String[] values = {"Laura","España","Madrid","5540500001000004","Diciembre","2030"};
        //Verify that the number of <input> elements matches the number of values.
        System.out.println(payOrder);
        if(payOrder.size() == values.length){
            for(int i = 0; i < payOrder.size(); i++){
                WebElement input = payOrder.get(i);
                String value = values[i];
                input.sendKeys(value);
            }
        }
        else{
            System.out.println("The number of <input> elements does not match the number of values.");
        }
        button = getByXpath("(//button[normalize-space()='Purchase'])[1]");
        sleep();
        button.click();
        sleep();
        button = getByXpath("(//button[normalize-space()='OK'])[1]");
        button.click();
        sleep();
    }
}
