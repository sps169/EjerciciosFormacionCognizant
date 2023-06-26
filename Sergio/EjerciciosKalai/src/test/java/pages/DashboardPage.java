package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends BasePage{

    @FindBy(css = "#j_idt105_content .ui-chkbox-box")
    public List<WebElement> checkBoxes;

    public WebElement email;

    public WebElement message;
    public DashboardPage(WebDriver driver) {
        super(driver, "https://www.leafground.com/dashboard.xhtml");
    }
}
