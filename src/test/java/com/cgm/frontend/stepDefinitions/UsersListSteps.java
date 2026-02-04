package com.cgm.frontend.stepDefinitions;

import static org.testng.Assert.assertEquals;

import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.utils.TestContext;

import io.cucumber.java.en.Then;

public class UsersListSteps {

    private TestContext context;
    private UsersListPage usersListPage;

    // Constructor injection of TestContext
    public UsersListSteps(TestContext context) {
        this.context = context;

        // Initialize UsersListPage only if not already done
        if (context.getUsersListPage() != null) {
            this.usersListPage = context.getUsersListPage();
        }
    }

    @Then("user should see the users list page")
    public void user_should_see_the_users_list_page() {
        // Get the shared UsersListPage from TestContext
        if (this.usersListPage == null) {
            this.usersListPage = context.getUsersListPage();
        }

        String headingText = usersListPage.getPageHeadingText();
        assertEquals(headingText, "User Management",
                "Users List page heading is not displayed correctly");
    }
}