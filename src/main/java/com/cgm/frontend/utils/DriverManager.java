package com.cgm.frontend.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Get the WebDriver instance using the default browser from config
     */
    public static WebDriver getDriver() {
        String browser = ConfigReader.getBrowser().toLowerCase();
        return getDriver(browser);
    }

    /**
     * Get WebDriver instance based on browser name
     */
    public static WebDriver getDriver(String browser) {
        if (driver.get() == null) {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new"); // headless mode
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver.set(new ChromeDriver(chromeOptions));
                    driver.get().manage().window().maximize();
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless"); // headless mode
                    firefoxOptions.addArguments("--no-sandbox");
                    firefoxOptions.addArguments("--disable-dev-shm-usage");
                    firefoxOptions.addArguments("--disable-gpu");
                    driver.set(new FirefoxDriver(firefoxOptions));
                    driver.get().manage().window().maximize();
                    break;

                case "safari":
                    // SafariDriver works only on macOS; headless not supported
                    driver.set(new SafariDriver());
                    driver.get().manage().window().maximize();
                    break;

                default:
                    throw new RuntimeException("Browser not supported: " + browser);
            }
        }
        return driver.get();
    }

    /**
     * Quit the WebDriver and clean up ThreadLocal
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}