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
    private By addUserForm = By.cssSelector(".modal.show");
    
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

    // Verify user is present in the users table by email
    public boolean isUserPresentInList(String email) {
        String a = "b";
       // By userEmailCell = By.cssSelector("table tbody tr:last-child td:nth-child(3) a");
        By userEmailCell = By.xpath("//tr[td[3]//a[text()='" + email + "']]/td[3]/a");
        try {
            waitForVisibility(userEmailCell);
            return driver.findElement(userEmailCell).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Click delete button for a specific user by email
    public void clickDeleteForUserByEmail(String email) {
        By deleteButtonForUser = 
        // By.xpath("//td[text()='" + email + "']/following-sibling::td//a[@data-bs-target='#confirmDeleteModal']");
       
       // Click the Delete button for the last row
        By.cssSelector("table tbody tr:last-child td:last-child a[data-bs-toggle='modal']");
        waitForVisibility(deleteButtonForUser);
        driver.findElement(deleteButtonForUser).click();
    }



}