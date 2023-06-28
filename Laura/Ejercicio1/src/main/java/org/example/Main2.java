package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.spec.ECField;
import java.time.Duration;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=taWzoLpdxaI");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));
        driver.manage().window().maximize();

        String xpathAcceptAll = "//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-" +
                "renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]";
        WebElement button, search, searchBtn, addBtn, videoLink, fscreen;

        button = driver.findElement(By.xpath(xpathAcceptAll));
        button.click();

        Thread.sleep(3000);
        search = driver.findElement(By.name("search_query"));
        search.click();
        search.sendKeys("rick roll song no ads");

        searchBtn = driver.findElement(By.id("search-icon-legacy"));
        searchBtn.click();

        videoLink = driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string"));
        videoLink.click();

        addBtn = driver.findElement(By.cssSelector("button.ytp-fullscreen-button.ytp-button"));
        addBtn.click();

    }
}