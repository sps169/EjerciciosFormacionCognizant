package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowPage extends BasePage{

    @FindBy(id = "j_idt88:new")
    public WebElement openTabBlueButton;

    @FindBy(id = "j_idt88:j_idt93")
    public WebElement openWindowYellowButton;

    @FindBy(id = "j_idt88:j_idt91")
    public WebElement openWindowPurpleButton;

    @FindBy(id = "j_idt88:j_idt95")
    public WebElement openTabsDelayGreenButton;

    public WindowPage(WebDriver driver) {
        super(driver, "https://www.leafground.com/window.xhtml");
    }
}
