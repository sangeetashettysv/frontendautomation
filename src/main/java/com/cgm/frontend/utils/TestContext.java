package com.cgm.frontend.utils;

import org.openqa.selenium.WebDriver;
import com.cgm.frontend.pages.UsersListPage;

public class TestContext {

    // WebDriver for the current scenario
    private WebDriver driver;

    // Shared UsersListPage object for the current scenario
    private UsersListPage usersListPage;

    // ----- WebDriver getters and setters -----
    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    // ----- UsersListPage getters and setters -----
    public UsersListPage getUsersListPage() {
        return usersListPage;
    }

    public void setUsersListPage(UsersListPage usersListPage) {
        this.usersListPage = usersListPage;
    }
}