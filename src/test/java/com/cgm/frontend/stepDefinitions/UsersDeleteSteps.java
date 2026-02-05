package com.cgm.frontend.stepDefinitions;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.pages.AddUserPage;
import com.cgm.frontend.pages.DeleteUserPage;
import com.cgm.frontend.stepDefinitions.UsersAddSteps;
import com.cgm.frontend.utils.TestContext;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class UsersDeleteSteps {

    private TestContext context;
    private UsersListPage usersListPage;
    private DeleteUserPage deleteUserPage;
    private UsersAddSteps addUserSteps;

    public UsersDeleteSteps(TestContext context, UsersAddSteps addUserSteps) {
        this.context = context;
        this.addUserSteps = addUserSteps;

        this.usersListPage = context.getUsersListPage();
        this.deleteUserPage = context.getDeleteUserPage();
    }

    // ---------------- Positive and Negative Steps ----------------

    @When("user creates a new user")
    public void user_creates_a_new_user() {
        addUserSteps.user_clicks_the_add_user_action();
        addUserSteps.user_enters_valid_user_details();
        addUserSteps.user_submits_the_add_user_form();

        assertTrue(usersListPage.isUserPresentInList(context.getCreatedUserEmail()),
                "Newly created user should appear in the users list");
    }

    @When("user clicks the delete action for the newly created user")
    public void user_clicks_the_delete_action_for_the_newly_created_user() {
        usersListPage.clickDeleteForUserByEmail(context.getCreatedUserEmail());

        // Ensure DeleteUserPage is initialized
        if (deleteUserPage == null) {
            deleteUserPage = new DeleteUserPage(context.getDriver());
            context.setDeleteUserPage(deleteUserPage);
        }
    }

    @Then("a delete confirmation dialog should be displayed")
    public void a_delete_confirmation_dialog_should_be_displayed() {
        assertTrue(deleteUserPage.isDialogDisplayed(),
                "Expected delete confirmation dialog to be displayed");
    }

    @When("user confirms deletion")
    public void user_confirms_deletion() {
        deleteUserPage.confirmDeletion();

        // Wait for modal to close, row to disappear, and toast to appear
        deleteUserPage.waitForModalToClose();
        deleteUserPage.waitForUserToBeDeleted(context.getCreatedUserEmail());
        // deleteUserPage.waitForDeleteSuccessToast();
    }

    @When("user cancels deletion")
    public void user_cancels_deletion() {
        deleteUserPage.cancelDeletion();
    }

    @Then("the deleted user should no longer appear in the users list")
    public void the_deleted_user_should_no_longer_appear_in_the_users_list() {
        assertFalse(usersListPage.isUserPresentInList(context.getCreatedUserEmail()),
                "Deleted user should no longer appear in the users list");
    }

    @Then("the user should still appear in the users list")
    public void the_user_should_still_appear_in_the_users_list() {
        assertTrue(usersListPage.isUserPresentInList(context.getCreatedUserEmail()),
                "User should still be present in the users list after cancelling deletion");
    }

    @Then("a delete success message should be shown to the user")
    public void a_delete_success_message_should_be_shown_to_the_user() {
        DeleteUserPage deleteUserPage = context.getDeleteUserPage();
        String deleteSuccessText = deleteUserPage.getDeleteSuccessToastMessage();
        assertEquals(deleteSuccessText, "User deleted successfully", 
                 "Delete message text mismatch");
    }

    // ---------------- Debug / Failing Step ----------------

    @Then("assert incorrectly that the user still appears in the users list")
    public void assert_incorrectly_user_still_appears_in_users_list() {
        // INTENTIONAL failure for debugging purposes
        assertTrue(usersListPage.isUserPresentInList(context.getCreatedUserEmail()),
                "INTENTIONAL FAILURE: This assertion is expected to fail");
    }
}
