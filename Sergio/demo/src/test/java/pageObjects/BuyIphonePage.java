package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuyIphonePage extends BasePageObject{


    public BuyIphonePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[@class=\"rf-hcard-content-title\" and contains(text()[last()], \"14 Pro\")]")
    public WebElement card;

    @FindBy(xpath = "//div[@class=\"rf-digitalmat-selecteditem\"]//button[text()=\"iPhone 14 Pro Max\"]")
    public WebElement proMaxButton;

    @FindBy(xpath = "//div[@class=\"rf-digitalmat-selecteditem\"]//a[@data-feature-name=\"iPhone 14 Pro Max modal\" and @class=\"button rf-digitalmat-button\"]")
    public WebElement buyButton;

    public void selectIphone14ProMax() {
        card.click();
        new WebDriverWait(driver, Duration.ofMillis(200), Duration.ofMillis(50)).until(ExpectedConditions.elementToBeClickable(proMaxButton));
        proMaxButton.click();
        buyButton.click();
    }


}
