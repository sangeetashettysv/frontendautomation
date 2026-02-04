package com.cgm.frontend.utils;

import org.openqa.selenium.WebDriver;

import com.cgm.frontend.pages.UsersListPage;
import com.cgm.frontend.pages.AddUserPage;

public class TestContext {

    private WebDriver driver;
    private UsersListPage usersListPage;
    private AddUserPage addUserPage;

    // ---------- Driver ----------
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- Users List Page ----------
    public UsersListPage getUsersListPage() {
        return usersListPage;
    }

    public void setUsersListPage(UsersListPage usersListPage) {
        this.usersListPage = usersListPage;
    }

    // ---------- Add User Page ----------
    public AddUserPage getAddUserPage() {
        return addUserPage;
    }

    public void setAddUserPage(AddUserPage addUserPage) {
        this.addUserPage = addUserPage;
    }

    private String createdUserEmail;

    public String getCreatedUserEmail() {
        return createdUserEmail;
    }

    public void setCreatedUserEmail(String createdUserEmail) {
        this.createdUserEmail = createdUserEmail;
    }
}