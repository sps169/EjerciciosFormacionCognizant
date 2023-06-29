package testScripts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.ButtonPage;

public class ButtonTest extends BaseTest{
    public ButtonTest(String browser) {
        super(browser);
    }

    @Test
    public void simpleClickButtonTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        page.pressClickableButton();
        Assert.assertEquals("Dashboard", driver.getTitle());
    }

    @Test
    public void disabledButtonTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        Assert.assertFalse(page.isDisabledButtonEnabled());
    }

    @Test
    public void getPositionSubmitTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        Assert.assertNotNull(page.findSubmitButtonLeftPosition());
    }

    @Test
    public void saveColorTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        Assert.assertEquals("rgba(96, 125, 139, 1)", page.getButtonColor(page.saveButton));
    }

    @Test
    public void sizeButtonTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        Assert.assertEquals(87 ,page.getSubmitButtonRightDimension().getWidth());
        Assert.assertEquals(34 ,page.getSubmitButtonRightDimension().getHeight());
    }

    @Test
    public void hoverSuccessButtonTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        String buttonInitialColor = page.getButtonColor(page.successButton);
        page.hoverGreenButton();
        String buttonCurrentColor = page.getButtonColor(page.successButton);
        Assert.assertNotEquals(buttonInitialColor, buttonCurrentColor);
    }
    @Test
    public void clickUnderImageTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        page.clickUnderImage();
        //what on earth do I assert here this button does nothing
        //not crashing is an assertion itself
    }

    @Test
    public void countRoundButtonsTest() {
        WebDriver driver = driverManager.getDriver();
        driver.get(ButtonPage.LINK);
        ButtonPage page = PageFactory.initElements(driver, ButtonPage.class);
        Assert.assertEquals(4, page.getRoundButtons());
    }
}
