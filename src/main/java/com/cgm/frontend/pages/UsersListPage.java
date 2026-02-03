package com.cgm.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.cgm.frontend.utils.ConfigReader;

public class UsersListPage extends BasePage {

    // Constructor
    public UsersListPage(WebDriver driver) {
        super(driver);
    }

    // Locator for page heading
    private By pageHeading = By.linkText("User Management");

    // Locators for Delete User
    private By deleteButton = By.cssSelector("a[data-bs-target='#confirmDeleteModal']");
    private By deleteConfirmationDialog = By.cssSelector(".modal.show");

    // Open application
    public void openApplication() {
        String env = ConfigReader.getEnvironment();
        String url = ConfigReader.getEnvironmentUrl();
        System.out.println("Opening application for environment: " + env + " | URL: " + url);
        driver.get(url);
    }

    // Get page heading text
    public String getPageHeadingText() {
        waitForVisibility(pageHeading);
        return driver.findElement(pageHeading).getText();
    }

    // Click delete for first user
    public void clickDeleteForFirstUser() {
        waitForVisibility(deleteButton);
        driver.findElement(deleteButton).click();
    }

    // Check if confirmation dialog is displayed
    public boolean isDeleteConfirmationDialogDisplayed() {
        waitForVisibility(deleteConfirmationDialog);
        return driver.findElement(deleteConfirmationDialog).isDisplayed();
    }
}