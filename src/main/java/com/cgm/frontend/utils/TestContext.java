package com.cgm.frontend.utils;

import org.openqa.selenium.WebDriver;
import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.pages.AddUserPage;
import com.cgm.frontend.pages.DeleteUserPage;

public class TestContext {

    private WebDriver driver;

    // Page Objects
    private UsersListPage usersListPage;
    private AddUserPage addUserPage;
    private DeleteUserPage deleteUserPage;

    // Test Data
    private String createdUserEmail;

    // ---------- Driver ----------
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- UsersListPage ----------
    public UsersListPage getUsersListPage() {
        if (usersListPage == null && driver != null) {
            usersListPage = new UsersListPage(driver);
        }
        return usersListPage;
    }

    public void setUsersListPage(UsersListPage usersListPage) {
        this.usersListPage = usersListPage;
    }

    // ---------- AddUserPage ----------
    public AddUserPage getAddUserPage() {
        if (addUserPage == null && driver != null) {
            addUserPage = new AddUserPage(driver);
        }
        return addUserPage;
    }

    public void setAddUserPage(AddUserPage addUserPage) {
        this.addUserPage = addUserPage;
    }

    // ---------- DeleteUserPage ----------
    public DeleteUserPage getDeleteUserPage() {
        if (deleteUserPage == null && driver != null) {
            deleteUserPage = new DeleteUserPage(driver);
        }
        return deleteUserPage;
    }

    public void setDeleteUserPage(DeleteUserPage deleteUserPage) {
        this.deleteUserPage = deleteUserPage;
    }

    // ---------- Created User Email ----------
    public String getCreatedUserEmail() {
        return createdUserEmail;
    }

    public void setCreatedUserEmail(String createdUserEmail) {
        this.createdUserEmail = createdUserEmail;
    }

    // ---------- Reset ----------
    public void reset() {
        usersListPage = null;
        addUserPage = null;
        deleteUserPage = null;
        createdUserEmail = null;
    }
}
