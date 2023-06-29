package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ButtonPage extends BasePage{

    public static final String LINK = "https://www.leafground.com/button.xhtml";

    @FindBy(id = "j_idt88:j_idt90")
    public WebElement clickableButton;

    @FindBy(id = "j_idt88:j_idt92")
    public WebElement disabledButton;

    @FindBy(id = "j_idt88:j_idt94")
    public WebElement submitButtonLeft;

    @FindBy(id = "j_idt88:j_idt96")
    public WebElement saveButton;

    @FindBy(id = "j_idt88:j_idt98")
    public WebElement submitButtonRight;

    @FindBy(id = "j_idt88:j_idt100")
    public WebElement successButton;

    @FindBy(id = "j_idt88:j_idt102:imageBtn")
    public WebElement imageButton;

    @FindBy(id = "j_idt88:j_idt107")
    public WebElement roundButtonBlue;

    @FindBy(id = "j_idt88:j_idt108")
    public WebElement roundButtonRed;
    @FindBy(id = "j_idt88:j_idt109")
    public WebElement roundButtonGreen;
    @FindBy(id = "j_idt88:j_idt110")
    public WebElement roundButtonYellow;


    public ButtonPage(WebDriver driver) {
        super(driver, LINK);
    }

    public void pressClickableButton() {
        clickableButton.click();
    }

    public boolean isDisabledButtonEnabled() {
        return disabledButton.isEnabled();
    }

    public Point findSubmitButtonLeftPosition() {
        return submitButtonLeft.getLocation();
    }

    public String getButtonColor(WebElement button) {
        return button.getCssValue("background-color");
    }

    public Dimension getSubmitButtonRightDimension() {
        return submitButtonRight.getSize();
    }

    public void hoverGreenButton() {
        new Actions(driver).moveToElement(successButton).build().perform();
    }

    public void clickUnderImage() {
        imageButton.click();
        new Actions(driver).moveToElement(roundButtonBlue, 0,  (roundButtonBlue.getSize().height * 4)/10).click().build().perform();
    }

    public int getRoundButtons() {
        return driver.findElements(By.cssSelector("button.rounded-button")).size();
    }
}
