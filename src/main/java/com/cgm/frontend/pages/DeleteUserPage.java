package com.cgm.frontend.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteUserPage extends BasePage {

    // Constructor
    public DeleteUserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // --- Locators ---
    private By modalDialog = By.cssSelector(".modal.show");
    private By modalTitle = By.cssSelector(".modal-header h5");
    private By modalText = By.cssSelector(".modal-body p");
    private By closeButton = By.cssSelector("button.btn-secondary");
    private By yesDeleteButton = By.cssSelector("button.btn-danger");
    private By closeIcon = By.cssSelector(".modal-header button.btn-close");
    private By deleteSuccessToast = By.cssSelector("div[role='status'][aria-live='polite']");

    // --- Methods ---

    // Check if the delete dialog is displayed
    public boolean isDialogDisplayed() {
        waitForVisibility(modalDialog);
        return driver.findElement(modalDialog).isDisplayed();
    }

    // Confirm deletion
    public void confirmDeletion() {
        waitForVisibility(yesDeleteButton);
        driver.findElement(yesDeleteButton).click();
    }

    // Cancel deletion via Close button
    public void cancelDeletion() {
        waitForVisibility(closeButton);
        driver.findElement(closeButton).click();
    }

    // Cancel deletion via Close icon
    public void cancelDeletionWithIcon() {
        waitForVisibility(closeIcon);
        driver.findElement(closeIcon).click();
    }

    // Get modal title
    public String getModalTitle() {
        waitForVisibility(modalTitle);
        return driver.findElement(modalTitle).getText();
    }

    // Get modal text
    public String getModalText() {
        waitForVisibility(modalText);
        return driver.findElement(modalText).getText();
    }

    // Check if success toast appeared
    public boolean wasDeleteSuccessToastDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessToast));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getDeleteSuccessToastMessage() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(ExpectedConditions.visibilityOfElementLocated(deleteSuccessToast));
            return driver.findElement(deleteSuccessToast).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
