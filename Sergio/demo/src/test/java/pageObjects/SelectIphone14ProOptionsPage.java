package pageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

public class SelectIphone14ProOptionsPage extends BasePageObject{

    @FindBy(xpath = "//span[@class=\"form-selector-title\" and contains(text(), \"iPhone 14 Pro Max\")]")
    private WebElement modelInput;

    @FindBy(xpath = "//input[@value=\"deeppurple\"]/label[@for=\"78a69e00-065b-11ee-b7a8-d1c972487562\"]")
    private WebElement colorRadio;

    @FindBy(xpath = "//input[@value=\"256gb\"]")
    private WebElement capacityInput;

    @FindBy(xpath = "//input[@value=\"noTradeIn\"]")
    private WebElement tradeInInput;

    @FindBy(xpath = "//input[@value=\"fullprice\"]")
    private WebElement paymentInput;

    @FindBy(name = "applecareplus_59")
    private WebElement appleCareInput;
    public SelectIphone14ProOptionsPage(WebDriver driver) {
        super(driver);
    }

    public void selectModelPreferences() {
//        new WebDriverWait(driver, Duration.ofSeconds(1), Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(modelInput));
        new Actions(driver)
                .scrollToElement(modelInput).click(modelInput)
                .scrollToElement(colorRadio).click(colorRadio)
                .scrollToElement(capacityInput).click(capacityInput)
                .scrollToElement(tradeInInput).click(paymentInput)
                .scrollToElement(paymentInput).click(paymentInput)
                .scrollToElement(appleCareInput).click(appleCareInput)
                        .build().perform();
    }

    public void waitFormInput(WebElement element) {
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30L))
                .pollingEvery(Duration.ofSeconds(5L))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
