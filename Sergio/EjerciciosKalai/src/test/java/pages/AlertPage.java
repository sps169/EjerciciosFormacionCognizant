package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class AlertPage extends BasePage{

    public static final String LINK = "https://www.leafground.com/alert.xhtml";

    public AlertPage(WebDriver driver) {
        super(driver, LINK);
    }

    @FindBy(id = "j_idt88:j_idt91")
    public WebElement whiteAlertButton;

    @FindBy(id = "simple_result")
    public WebElement whiteAlertResult;

    @FindBy(id = "j_idt88:j_idt93")
    public WebElement yellowAlertButton;

    @FindBy(id = "result")
    public WebElement yellowAlertResult;

    @FindBy(id = "j_idt88:j_idt95")
    public WebElement blueAlertButton;

    @FindBy(id = "j_idt88:j_idt96")
    public WebElement blueAlert;

    @FindBy(id = "j_idt88:j_idt98")
    public WebElement blueAlertDismissButton;

    @FindBy(id = "j_idt88:j_idt100")
    public WebElement purpleAlertButton;

    @FindBy(id = "j_idt88:j_idt101")
    public WebElement purpleAlert;

    @FindBy(css = "#j_idt88\\:j_idt101 [aria-label=\"Close\"]")
    public WebElement purpleAlertDismiss;

    @FindBy(id = "j_idt88:j_idt104")
    public WebElement greenAlertButton;

    @FindBy(id = "confirm_result")
    public WebElement greenAlertResult;

    @FindBy(id = "j_idt88:j_idt106")
    public WebElement redAlertButton;

    @FindBy(id = "j_idt88:j_idt107")
    public WebElement redAlert;

    @FindBy(id = "j_idt88:j_idt108")
    public WebElement redAlertYes;

    @FindBy(id = "j_idt88:j_idt109")
    public WebElement redAlertNo;

    @FindBy(id = "j_idt88:j_idt111")
    public WebElement whiteMinMaxButton;

    @FindBy(id = "j_idt88:j_idt112")
    public WebElement whiteMinMaxAlert;

    @FindBy(css = "#j_idt88\\:j_idt112 .ui-dialog-titlebar-minimize")
    public WebElement minMaxAlertMinButton;

    @FindBy(css = "#j_idt88\\:j_idt112 .ui-dialog-titlebar-maximize")
    public WebElement minMaxAlertMaxButton;

    @FindBy(css = "#j_idt88\\:j_idt112 .ui-dialog-titlebar-close")
    public WebElement minMaxAlertCloseButton;

    public void alertAction(WebElement alertButton) {
        alertButton.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void alertAction(WebElement alertButton, String keys) {
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        if (keys != null)
            alert.sendKeys(keys);
        alert.accept();
        driver.switchTo().defaultContent();
    }

    public String getWhiteAlertText() {
        return whiteAlertResult.getText();
    }


    public String getYellowAlertText() {
        return yellowAlertResult.getText();
    }

    public String getGreenAlertText() {
        return greenAlertResult.getText();
    }

    public void embeddedAlertOpen(WebElement alert, WebElement alertButton) {
        alertButton.click();
        waitAlertFadeIn(alert);
    }

    public void embeddedAlertDismiss(WebElement alert, WebElement alertDismiss) {
        if (alert.isDisplayed()) {
            alertDismiss.click();
            waitAlertFadeAway(alert);
        }
    }

    private void waitAlertFadeIn(WebElement alert) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOf(alert));
    }
    private void waitAlertFadeAway(WebElement alert) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(not(ExpectedConditions.visibilityOf(alert)));
    }

    public void minMaxAlertMinimize() {
        ExpectedCondition<Boolean> waitCondition = null;
        if (whiteMinMaxAlert.getAttribute("class").contains("ui-dialog-minimized"))
            waitCondition = ExpectedConditions.not(ExpectedConditions.attributeContains(whiteMinMaxAlert, "class", "ui-dialog-minimized"));
        else
            waitCondition = ExpectedConditions.attributeContains(whiteMinMaxAlert, "class", "ui-dialog-minimized");
        minMaxAlertMinButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(waitCondition);
    }

    public void minMaxAlertMaximize() {
        ExpectedCondition<Boolean> waitCondition = null;
        if (whiteMinMaxAlert.getAttribute("class").contains("ui-dialog-maximized"))
            waitCondition = ExpectedConditions.not(ExpectedConditions.attributeContains(whiteMinMaxAlert, "class", "ui-dialog-maximized"));
        else
            waitCondition = ExpectedConditions.attributeContains(whiteMinMaxAlert, "class", "ui-dialog-maximized");
        minMaxAlertMaxButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(waitCondition);
    }
}
