package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.When;

public class AccountActivityNavigationStepDefs {

    AccountActivityPage activityPage = new AccountActivityPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String link) {
        activityPage.getlinks(link).click();

    }

}
