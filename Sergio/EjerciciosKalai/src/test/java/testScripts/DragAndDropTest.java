package testScripts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest{
    public DragAndDropTest(String browser) {
        super(browser);
    }

    @Test
    public void testDraggable() {
        WebDriver driver = driverManager.getDriver();
        driver.get(DragAndDropPage.LINK);
        DragAndDropPage page = PageFactory.initElements(driver, DragAndDropPage.class);
        Point initPos = page.draggable.getLocation();
        page.moveDraggableForward();
        Point currentPos = page.draggable.getLocation();
        Assert.assertNotEquals(initPos.getX(), currentPos.getX());
        Assert.assertEquals(initPos.getY(), currentPos.getY());
        page.moveDraggableBackward();
        Point lastPos = page.draggable.getLocation();
        Assert.assertEquals(initPos.getX(), lastPos.getX());
        Assert.assertEquals(initPos.getY(), lastPos.getY());
    }

    @Test
    public void testDragAndDrop() {
        WebDriver driver = driverManager.getDriver();
        driver.get(DragAndDropPage.LINK);
        DragAndDropPage page = PageFactory.initElements(driver, DragAndDropPage.class);
        String initialText = page.getDropTargetText();
        page.dropObjectInTarget();
        String currentText = page.getDropTargetText();
        Assert.assertNotEquals(initialText, currentText);
    }
}
