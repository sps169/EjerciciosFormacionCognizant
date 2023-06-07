package org.proyecto1;

public class Main {
    public static void main(String[] args) {
        ChooseProduct product = new ChooseProduct();
        product.clickCategory();
        product.clickProduct();
        product.addProductToCart();
        product.clickCart();
        product.payProduct();
        product.quit();
    }
}