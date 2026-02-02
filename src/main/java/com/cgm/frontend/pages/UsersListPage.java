package com.cgm.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cgm.frontend.utils.ConfigReader;

public class UsersListPage {

    private WebDriver driver;

    // Locator for page heading
    private By pageHeading = By.xpath("//*[@id=\"root\"]/div/nav/div/a");

    // Constructor
    public UsersListPage(WebDriver driver) {
    this.driver = driver;
    }

    // Open application
    public void openApplication() {
        String env = ConfigReader.getEnvironment();
        String url = ConfigReader.getEnvironmentUrl();
        System.out.println("Opening application for environment: " + env + " | URL: " + url);
        driver.get(url);
    }

    // Get page heading text
    public String getPageHeadingText() {
        return driver.findElement(pageHeading).getText();
    }
}