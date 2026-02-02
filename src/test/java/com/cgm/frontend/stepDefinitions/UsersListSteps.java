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

    @Given("user opens the application on {string}")
    public void user_opens_the_application_on(String browser) {
        driver = DriverManager.getDriver(browser);
        usersListPage = new UsersListPage(driver);
        usersListPage.openApplication();
    }

    @Then("user should see the users list page")
    public void user_should_see_the_users_list_page() {
        String headingText = usersListPage.getPageHeadingText();
        assertEquals(headingText, "User Management",
                "Users List page heading is not displayed correctly");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}