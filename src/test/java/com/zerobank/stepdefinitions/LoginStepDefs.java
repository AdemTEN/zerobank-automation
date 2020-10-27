package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.onLoginPage();
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        loginPage.loginWithValidCredentials();


    }

    @Then("{string} page should be displayed")
    public void page_should_be_displayed(String expectedPageName) {
        Assert.assertEquals(expectedPageName, new AccountSummaryPage().getPageName(expectedPageName).getText());

    }

    @When("user enter {string} as username and {string} as password")
    public void user_enter_as_username_and_as_password(String username, String password) {
        loginPage.loginWithWrongCredentials(username, password);
    }


    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.message.getText());
    }


}
