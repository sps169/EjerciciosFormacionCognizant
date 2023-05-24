package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ejercicio1 {

    private static Ejercicio1 instance;
    private static final String LINK = "https://www.youtube.com";
    private WebDriver driver = new ChromeDriver();
    private WebDriverWait wait = new WebDriverWait(
            driver,
            Duration.ofSeconds(30),
            Duration.ofMillis(100)
    );
    private Ejercicio1() {

    }

    public static Ejercicio1 getInstance() {
        if (instance == null)
            instance = new Ejercicio1();
        return instance;
    }

    public WebElement fluentWait(final By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ElementClickInterceptedException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return  foo;
    };
    public void run() {
        driver.get(LINK);

        //print title
        System.out.println("Page title: " + driver.getTitle());

        //resize window
        driver.manage().window().setSize(new Dimension(1280, 720));

        //reject message
        WebElement rejectButton = fluentWait(By.xpath("//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[1]/yt-button-shape/button"));
        rejectButton.click();


        //search "dog thing" in search bar
        searchQuery();

        //select item from video list
        WebElement video = selectVideo();

        //play video at link
        player(video.getAttribute("href"));
    }

    private WebElement selectVideo() {
        WebElement video = null;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        boolean videoFound = false;

        while(!videoFound) {
            List<WebElement> videoList = driver.findElements(By.id("video-title"));
            System.out.println("Found " + videoList.size()+ " videos");
            video = videoList.stream().filter(e -> e.getAttribute("title").equals("dog thing")).findFirst().orElse(null);
            if (video != null)
                videoFound = true;
        }
        return video;
    }

    private void searchQuery() {
        WebElement searchBar = fluentWait(By.name("search_query"));
        System.out.println("Displayed: " + searchBar.isDisplayed());
        System.out.println("Enabled: " + searchBar.isEnabled());
        Action sendKeys = new Actions(driver)
                .moveToElement(searchBar)
                .click()
                .sendKeys(searchBar,"dog thing")
                .build();
        WebElement form = fluentWait(By.id("search-form"));

        wait.until(new Function<WebDriver, Boolean>() {

            @Override
            public Boolean apply(WebDriver webDriver) {
                sendKeys.perform();
                return true;
            }
        });
        form.submit();
    }

    public void player(String url) {
        driver.get(url);
        List<WebElement> buttons = driver.findElements(By.tagName("button")).stream().filter(e -> e.getAttribute("title").contains("Play (k)")).collect(Collectors.toList());
        System.out.println("Found " + buttons.size() + " buttons containing \"Play (k)\"");
        if (buttons.size() > 0)
        {
            new Actions(driver).moveToElement(buttons.get(0)).click().perform();
            new Actions(driver).moveToElement(buttons.get(0)).perform();
            WebElement timeDurationElement = null;
            try {
                timeDurationElement = fluentWait(By.cssSelector("span.ytp-time-duration"));
            } catch (NoSuchElementException e) {
                System.err.println("Time duration element not found");
            }
            int millis = 30000;
            if (timeDurationElement != null)
            {
                System.out.println(timeDurationElement.getText());
                millis = timeDurationToMillis(timeDurationElement.getText());
            }
            try {
                System.out.println("Sleep " + (millis + 1000) + " millis");
                Thread.sleep(millis + 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        driver.close();
    }

    public int timeDurationToMillis(String timeDuration)
    {
        int result = 0;
        String[] time = timeDuration.split(":");
        if (time.length != 2)
            return result;
        result += Integer.parseInt(time[0]) * 60000;
        result += Integer.parseInt(time[1]) * 1000;
        return result;
    }
}
