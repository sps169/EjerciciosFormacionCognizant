package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.*;
import java.time.Duration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Chrome Driver
        WebDriver driver = new ChromeDriver();
        driver.get("https://youtu.be/taWzoLpdxaI");
        WebElement button, search, searchBtn, addBtn, videoLink, time;
        String xPath;

        //maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.manage().window().maximize();

        //Accept button
        xPath = "//*[@id=\"content\"]/div[2]/div[6]/div[1]/ytd-button-renderer[2]/yt-button-shape/button/yt-touch-feedback-shape/div/div[2]";
        button = driver.findElement(By.xpath(xPath));
        button.click();

        //Change video
        Thread.sleep(3000);
        search = driver.findElement(By.name("search_query"));
        search.click();
        search.sendKeys("SFDK Ft. Swan Fyahbwoy - TODO LO QUE IMPORTA - SIN MIEDO A VIVIR - 2014 (+LETRA)");

        //Search Button
        searchBtn = driver.findElement(By.id("search-icon-legacy"));
        searchBtn.click();

        //new video
        videoLink = driver.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string"));
        videoLink.click();

        //miniplayer screen
        addBtn = driver.findElement(By.cssSelector("button.ytp-miniplayer-button.ytp-button"));
        addBtn.click();

        // Gets duration label of the video
        time = driver.findElement(By.xpath("//*[@id=\"movie_player\"]/div[37]/div[2]/div[1]/div[1]/span[2]/span[3]"));

        //Extracts minutes and seconds from "00:00" format
        int total = Integer.parseInt(time.getText().split(":")[0]) +
        Integer.parseInt(time.getText().split(":")[1]);
        System.out.println(total);
        //Waits the duration in second of the video *1000 to input miliseconds
        Thread.sleep(total*1000);
    }
}