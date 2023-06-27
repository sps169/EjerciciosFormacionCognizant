package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FramePage extends BasePage{

    public static final String LINK = "https://www.leafground.com/frame.xhtml";
    public FramePage(WebDriver driver) {
        super(driver, LINK);
    }
    @FindBy(css = "iframe")
    List<WebElement> iframes;
    public void clickOrangeButton() {
        WebElement iFrameOrange = iframes.get(1);
        driver.switchTo().frame(iFrameOrange);
        iFrameOrange.findElement(By.id("Click")).click();
        driver.switchTo().parentFrame();
    }


    public void clickPurpleButton() {
        WebElement iframePurple = iframes.get(3);
        driver.switchTo().frame(iframePurple);
        WebElement iframeNested = iframePurple.findElement(By.cssSelector("iframe"));
        driver.switchTo().frame(iframeNested).findElement(By.id("Click")).click();
        driver.switchTo().parentFrame();
    }

    public long countiFrames() {
        return iframes.stream().map(this::countChildFrames).reduce(Integer::sum).orElse(0);
    }

    private int countChildFrames(WebElement iframe) {
        int count = 0;
        driver.switchTo().frame(iframe);
        List<WebElement> children = driver.findElements(By.cssSelector("iframe"));
        count += 1;
        if (children.size() != 0) {
            for (WebElement child: children) {
                count += countChildFrames(child);
            }
        }
        driver.switchTo().parentFrame();
        return count;
    }

}
