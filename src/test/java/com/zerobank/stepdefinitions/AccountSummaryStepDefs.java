package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @Then("page should have following account types")
    public void page_should_have_following_account_types(List<String> expectedAccountTypes) {

        accountSummaryPage.getAccountTypes(expectedAccountTypes);

    }

    @Then("Credit Accounts table must have following columns")
    public void credit_Accounts_table_must_have_following_columns(List<String> expectedCreditAccountsColumns) {
        accountSummaryPage.getTableHeader(expectedCreditAccountsColumns);

    }
}
