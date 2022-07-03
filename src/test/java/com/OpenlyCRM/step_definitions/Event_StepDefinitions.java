package com.OpenlyCRM.step_definitions;

import com.OpenlyCRM.pages.LoginPage;
import com.OpenlyCRM.utilities.ConfigurationReader;
import com.OpenlyCRM.utilities.Driver;
import io.cucumber.java.en.Given;

public class Event_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user on home page")
    public void user_on_home_page() {
        loginPage.login();
    }
}
