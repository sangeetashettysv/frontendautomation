package com.cgm.frontend.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.cgm.frontend.pages.AddUserPage;
import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.utils.TestContext;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersAddSteps {

    private final TestContext context;
    private UsersListPage usersListPage;
    private AddUserPage addUserPage;

    // PicoContainer constructor injection
    public UsersAddSteps(TestContext context) {
        this.context = context;

        this.usersListPage = context.getUsersListPage();
        this.addUserPage = context.getAddUserPage();
    }

    // ---------- ACTION STEPS ----------

    @When("user clicks the Add User action")
    public void user_clicks_the_add_user_action() {
        usersListPage.clickAddUser();

        // Initialize AddUserPage once popup is opened
        if (context.getAddUserPage() == null) {
            context.setAddUserPage(new AddUserPage(context.getDriver()));
        }
        addUserPage = context.getAddUserPage();
    }

    @When("user enters valid user details")
    public void user_enters_valid_user_details() {
        String email = "john@doe.com";
        addUserPage.fillName("John Doe");
        addUserPage.fillUsername("johndoe");
        addUserPage.fillEmail("john@doe.com");
        addUserPage.fillPhone("9812345678");
        addUserPage.fillWebsite("https://johndoe.com");
        context.setCreatedUserEmail(email);
    }

    @When("user enters invalid email")
    public void user_enters_invalid_email() {
        addUserPage.fillName("John Doe");
        addUserPage.fillUsername("johndoe");
        addUserPage.fillEmail("a"); // invalid on purpose
    }

    @When("user enters invalid phone number")
    public void user_enters_invalid_phone_number() {
        addUserPage.fillEmail("john@doe.com");
        addUserPage.fillPhone("123"); // invalid
    }

    @When("user submits the Add User form")
    public void user_submits_the_add_user_form() {
        assertTrue(addUserPage.isAddButtonEnabled(),
                "Add button should be enabled when all fields are valid");
        addUserPage.clickAddButton();
    }

    // ---------- VERIFICATION STEPS ----------

    @Then("Add User form should be displayed")
    public void add_user_form_should_be_displayed() {
        assertTrue(addUserPage.isAddUserFormDisplayed(),
                "Add User popup should be visible");
    }

    @Then("Add button should be enabled")
    public void add_button_should_be_enabled() {
        assertTrue(addUserPage.isAddButtonEnabled(),
                "Add button should be enabled for valid input");
    }

    @Then("Add button should be disabled")
    public void add_button_should_be_disabled() {
        assertFalse(addUserPage.isAddButtonEnabled(),
                "Add button should remain disabled for invalid input");
    }

    @Then("email validation error should be shown")
    public void email_validation_error_should_be_shown() {
        assertTrue(addUserPage.isEmailErrorDisplayed(),
                "Email validation error should be displayed");
    }

    @Then("phone validation error should be shown")
    public void phone_validation_error_should_be_shown() {
        assertTrue(addUserPage.isPhoneErrorDisplayed(),
                "Phone validation error should be displayed");
    }

    // ❌ INTENTIONALLY FAILING TEST (for debugging practice)
    @Then("Add button should still be enabled")
    public void add_button_should_still_be_enabled() {
        // This is intentionally wrong – button SHOULD be disabled
        assertTrue(addUserPage.isAddButtonEnabled(),
                "INTENTIONAL FAILURE: Add button should NOT be enabled");
    }

    @Then("the newly added user should appear in the users list")
    public void the_newly_added_user_should_appear_in_the_users_list() {
        String email = context.getCreatedUserEmail();

        assertTrue(
            usersListPage.isUserPresentInList(email),
            "Expected newly added user to appear in the users list"
        );
    }

    @Then("a success message should be shown to the user")
    public void a_success_message_should_be_shown_to_the_user() {
        assertTrue(addUserPage.wasSuccessToastDisplayed(),
                "Expected success toast to appear after adding user");

        // Optional strict assertion (can be flaky by design)
        assertEquals(
                addUserPage.getSuccessToastMessage(),
                "User added successfully",
                "Success message text mismatch"
        );
    }

}