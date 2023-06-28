package org.example;

import java.io.File;

public class SeleniumConfig {

    private static final String DRIVER_PATH = SeleniumConfig.class.getClassLoader().getResource("selenium/chromedriver.exe").getFile();
    public static void config() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }
}
