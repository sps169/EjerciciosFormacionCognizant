package org.example.First_Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Youtube_exercise {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=xvFZjo5PgG0");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
        driver.manage().window().maximize();
        String xpathAcceptAll =  "//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-" +
                            "renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]";
        WebElement button, search, searchBtn, videoLink, fscreen, time;

        button = driver.findElement(By.xpath(xpathAcceptAll));
        button.click();

        Thread.sleep(3000);

        time = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[28]/div[2]/div[1]/div[1]/span[2]/span[3]"));

        int total = Integer.parseInt(time.getText().split(":")[0]) +
                    Integer.parseInt(time.getText().split(":")[1]);
        System.out.println(total);
        Thread.sleep(total*1000);

        search = driver.findElement(By.name("search_query"));
        search.click();
        search.sendKeys(song());


        Thread.sleep(500);

        searchBtn = driver.findElement(By.id("search-icon-legacy"));
        searchBtn.click();

        videoLink = driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string"));
        videoLink.click();

        fscreen = driver.findElement(By.cssSelector("button.ytp-fullscreen-button.ytp-button"));
        fscreen.click();

    }
    public static String song() {
        String alpha = "abcdefghijklmnopqrstuvwxyz", text = "ulfncuroocvrqjcqrcdgvc";
        String message = "";
        for (int ii = 0; ii < text.length(); ii++) {
            int charPosition = alpha.indexOf(text.charAt(ii));
            int keyVal = (charPosition - 3) % 26;
            if (keyVal < 0) {
                keyVal = alpha.length() + keyVal;
            }
            char replaceVal = alpha.charAt(keyVal);
            message += replaceVal;
        }
        return message.replace("z", " ");
    }
}
