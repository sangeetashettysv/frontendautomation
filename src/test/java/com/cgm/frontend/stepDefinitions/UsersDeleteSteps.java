package com.cgm.frontend.stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.utils.ConfigReader;
import com.cgm.frontend.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class UsersDeleteSteps {

    private WebDriver driver;
    private UsersListPage usersListPage;

    // --- Step: navigate to Users List page ---
    @Given("I am on the Users List page")
    public void i_am_on_the_users_list_page() {
        // Get browser from ConfigReader (default to chrome if not set)
        String browser = ConfigReader.getBrowser();
        driver = DriverManager.getDriver(browser);

        // Initialize UsersListPage and open the application
        usersListPage = new UsersListPage(driver);
        usersListPage.openApplication();
    }

    // --- Step: click delete for first user ---
    @When("I click the delete action for a user")
    public void i_click_the_delete_action_for_a_user() {
        usersListPage.clickDeleteForFirstUser();
    }

    // --- Step: verify confirmation dialog ---
    @Then("a delete confirmation dialog should be displayed")
    public void a_delete_confirmation_dialog_should_be_displayed() {
        assertTrue(
            usersListPage.isDeleteConfirmationDialogDisplayed(),
            "Expected delete confirmation dialog to be displayed"
        );
    }

    // --- Cleanup ---
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}