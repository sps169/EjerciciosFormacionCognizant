package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FrontPage extends BasePageObject{

    public static final String LINK = "https://www.apple.com/es/";
    @FindBy(xpath = "//span[@class=\"globalnav-link-text-container\"]")
    public WebElement storeNavButton;

    public FrontPage(WebDriver driver) {
        super(driver);
    }
    public void navToStore() {
        storeNavButton.click();
    }
}
