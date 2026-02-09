package com.cgm.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cgm.frontend.utils.ConfigReader;

public class HomePage extends BasePage{

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver); 
        PageFactory.initElements(driver, this);
    }

    // Open application
    public void openApplication() {
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