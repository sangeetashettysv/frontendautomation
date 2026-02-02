package com.cgm.frontend.pages;

import org.openqa.selenium.WebDriver;
import com.cgm.frontend.utils.ConfigReader;

public class HomePage {

    private WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open application
    public void openApplication() {
    // Directly use getEnvironmentUrl() which internally handles the environment
    String url = ConfigReader.getEnvironmentUrl();
    if (url == null || url.isEmpty()) {
        throw new RuntimeException("Base URL not found in config.properties!");
    }
    driver.get(url);
    }

    // Action: get page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}