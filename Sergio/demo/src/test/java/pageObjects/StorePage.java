package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends BasePageObject{

    public StorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class=\"rf-productnav-card-title\" and text()=\"iPhone\"]")
    public WebElement iPhoneLink;

    public void navToIphoneLink() {
        iPhoneLink.click();
    }
}
