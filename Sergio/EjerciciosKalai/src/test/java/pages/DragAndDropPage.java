package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends BasePage{

    public static final String LINK = "https://www.leafground.com/drag.xhtml";

    public DragAndDropPage(WebDriver driver) {
        super(driver, LINK);
    }

    @FindBy(id = "form:conpnl")
    public WebElement draggable;

    @FindBy(id = "form:drag_content")
    public WebElement dropObject;

    @FindBy(id = "form:drop_content")
    public WebElement dropTarget;

    @FindBy(css = "#form\\:drop_content .ui-widget-header")
    public WebElement dropTargetContent;

    public void moveDraggableForward () {
        new Actions(driver)
                .dragAndDropBy(draggable, 200, 0)
                .build().perform();
    }

    public void moveDraggableBackward () {
        new Actions(driver)
                .dragAndDropBy(draggable, -200, 0)
                .build().perform();
    }

    public void dropObjectInTarget() {
        new Actions(driver)
                .dragAndDrop(dropObject, dropTarget)
                .build()
                .perform();
    }

    public String getDropTargetText() {
        return dropTargetContent.getText();
    }
}
