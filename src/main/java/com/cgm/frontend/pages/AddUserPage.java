package com.cgm.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends BasePage {

    // Constructor
    public AddUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // --- Locators ---

    private By addUserPopup = By.cssSelector(".modal-content .modal-header");
    private By nameField = By.cssSelector("input[type='text'][name='name']");
    private By usernameField = By.cssSelector("input[type='text'][name='username']");
    private By emailField = By.cssSelector("input[type='email'][name='email']");
    private By phoneField = By.cssSelector("input[type='tel'][name='phone']");
    private By websiteField = By.cssSelector("input[type='url'][name='website']");
    private By addButtonOnPopup = By.cssSelector("button[type='submit'][data-bs-dismiss='modal']");

    private By emailError = By.cssSelector("input[name='email'] + .invalid-feedback");
    private By phoneError = By.cssSelector("input[name='phone'] + .invalid-feedback");
    private By websiteError = By.cssSelector("input[name='website'] + .invalid-feedback");

    // --- Methods ---

    // Check if the Add User popup is displayed
    public boolean isAddUserFormDisplayed() {
        waitForVisibility(addUserPopup);
        return driver.findElement(addUserPopup).isDisplayed();
    }

    // Fill individual fields
    public void fillName(String name) {
        waitForVisibility(nameField);
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void fillUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void fillEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPhone(String phone) {
        driver.findElement(phoneField).clear();
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void fillWebsite(String website) {
        driver.findElement(websiteField).clear();
        driver.findElement(websiteField).sendKeys(website);
    }

    // Check if Add button is enabled
    public boolean isAddButtonEnabled() {
        waitForVisibility(addButtonOnPopup);
        return driver.findElement(addButtonOnPopup).isEnabled();
    }

    // Click Add button
    public void clickAddButton() {
        waitForVisibility(addButtonOnPopup);
        driver.findElement(addButtonOnPopup).click();
    }

    // Validation error checks
    public boolean isEmailErrorDisplayed() {
        try {
            return driver.findElement(emailError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPhoneErrorDisplayed() {
        try {
            return driver.findElement(phoneError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isWebsiteErrorDisplayed() {
        try {
            return driver.findElement(websiteError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

   