package com.cgm.frontend.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        return getDriver(browser);
    }

    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver.set(new ChromeDriver(chromeOptions));
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver.set(new FirefoxDriver(firefoxOptions));
                    driver.get().manage().window().maximize();
                    break;

                case "safari":
                    // SafariDriver works only on Mac
                    driver.set(new SafariDriver());
                    driver.get().manage().window().maximize();
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}