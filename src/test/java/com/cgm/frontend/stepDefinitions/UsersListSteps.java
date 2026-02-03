package com.cgm.frontend.stepDefinitions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UsersListSteps {

    private WebDriver driver;
    private UsersListPage usersListPage;

    // --- Step: open application on a given browser ---
    @Given("user opens the application on {string}")
    public void user_opens_the_application_on(String browser) {
        // Initialize WebDriver for the given browser
        driver = DriverManager.getDriver(browser);

        // Initialize Page Object and open the application
        usersListPage = new UsersListPage(driver);
        usersListPage.openApplication();
    }

    // --- Step: verify Users List page heading ---
    @Then("user should see the users list page")
    public void user_should_see_the_users_list_page() {
        String headingText = usersListPage.getPageHeadingText();
        assertEquals(headingText, "User Management",
                     "Users List page heading is not displayed correctly");
    }

    // --- Cleanup: quit driver after scenario ---
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}