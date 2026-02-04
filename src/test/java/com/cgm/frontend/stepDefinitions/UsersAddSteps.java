package com.cgm.frontend.stepDefinitions;

import static org.testng.Assert.assertTrue;

import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.utils.TestContext;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class UsersAddSteps {

    private TestContext context;
    private UsersListPage usersListPage;

    // Constructor injection
    public UsersAddSteps(TestContext context) {
        this.context = context;

        // Get the shared UsersListPage from TestContext if already initialized
        if (context.getUsersListPage() != null) {
            this.usersListPage = context.getUsersListPage();
        }
    }

    @When("user clicks the Add User action")
    public void user_clicks_the_add_user_action() {
        // Ensure the page object is available
        if (this.usersListPage == null) {
            this.usersListPage = context.getUsersListPage();
        }
        usersListPage.clickAddUser();
    }

    @Then("user should see the Add User form")
    public void user_should_see_the_add_user_form() {
        // Ensure the page object is available
        if (this.usersListPage == null) {
            this.usersListPage = context.getUsersListPage();
        }
        assertTrue(usersListPage.isAddUserFormDisplayed(),
                "Expected Add User form to be displayed");
    }
}