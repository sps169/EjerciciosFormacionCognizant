package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
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

    @FindBy(xpath = "//input[@value=\"deeppurple\"]/following::label[1]")
    private WebElement colorRadio;

    @FindBy(xpath = "//input[@value=\"256gb\"]/following::label[1]")
    private WebElement capacityInput;

    @FindBy(xpath = "//input[@value=\"noTradeIn\"]/following::label[1]")
    private WebElement tradeInInput;

    @FindBy(xpath = "//input[@value=\"fullprice\"]/following::label[1]")
    private WebElement paymentInput;

    @FindBy(name = "applecareplus_59")
    private WebElement appleCareInput;
    public SelectIphone14ProOptionsPage(WebDriver driver) {
        super(driver);
    }

    public void selectModelPreferences() {
//        new WebDriverWait(driver, Duration.ofSeconds(1), Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(modelInput));
        modelInput = doActionOrReload(modelInput, By.xpath("//span[@class=\"form-selector-title\" and contains(text(), \"iPhone 14 Pro Max\")]"));
        colorRadio = doActionOrReload(colorRadio, By.xpath("//input[@value=\"deeppurple\"]/following::label[1]"));
        capacityInput = doActionOrReload(capacityInput, By.xpath("//input[@value=\"256gb\"]/following::label[1]"));
        tradeInInput = doActionOrReload(tradeInInput, By.xpath("//input[@value=\"noTradeIn\"]/following::label[1]"));
        paymentInput = doActionOrReload(paymentInput, By.xpath("//input[@value=\"fullprice\"]/following::label[1]"));
        appleCareInput = doActionOrReload(appleCareInput, By.name("applecareplus_59"));
    }

    public void waitFormInput(WebElement element) {

        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement doActionOrReload(WebElement element, By by) {
        waitFormInput(element);
        Action actions = new Actions(driver).scrollToElement(element).click(element).build();
        try {
            actions.perform();
        } catch (StaleElementReferenceException e) {
            element = driver.findElement(by);
            actions.perform();
        }
        return element;
    }

}
