package com.cgm.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cgm.frontend.utils.ConfigReader;

public class UsersListPage extends BasePage {

    // Constructor
    public UsersListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Locator for page heading
    private By pageHeading = By.linkText("User Management");

    // Locator for Add User button/action
    private By addUserButton = By.cssSelector("button[data-bs-target='#addUserModal']");

    // Locator for Add User form/modal
    private By addUserForm = By.cssSelector(".modal.show"); // adjust if needed based on actual modal class
    
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

    // Click the Add User button
    public void clickAddUser() {
        waitForVisibility(addUserButton);
        driver.findElement(addUserButton).click();
    }

    // Verify the Add User form/modal is displayed
    public boolean isAddUserFormDisplayed() {
        waitForVisibility(addUserForm);
        return driver.findElement(addUserForm).isDisplayed();
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