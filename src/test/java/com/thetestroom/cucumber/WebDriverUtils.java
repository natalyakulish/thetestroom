package com.thetestroom.cucumber;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * Created by natalyakulish on 29.09.17.
 */
public class WebDriverUtils {

    private static WebDriver driver;

    public static WebDriver getNewChromeDriver() {

        ChromeDriverManager.getInstance().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        return driver;
    }

    public static WebDriver getExistingChromeDriver() {
        if (driver == null) {
            driver = getNewChromeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
