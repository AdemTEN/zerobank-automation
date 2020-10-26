package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDef {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("the user click on {string} page")
    public void the_user_click_on_page(String pageName) {
       accountSummaryPage.getPageName(pageName).click();
       BrowserUtils.waitFor(2);


    }

    @Then("verify Account dropdown default option should be {string}")
    public void verify_Account_dropdown_default_option_should_be(String expectedDefaultOption) {
        Select accountDropdown = accountActivityPage.accountOptionList();
        Assert.assertEquals(expectedDefaultOption, accountDropdown.getFirstSelectedOption().getText());

    }

    @Then("Account dropdown should have following options:")
    public void account_dropdown_should_have_following_options(List<String> expectedOptions) {
        Select accountDropdown = accountActivityPage.accountOptionList();
        List<WebElement> accountOptions = accountDropdown.getOptions();
        List<String> actualOptions = BrowserUtils.getElementsText(accountOptions);
        Assert.assertEquals(expectedOptions,actualOptions);

    }

    @Then("Transactions table should have column names:")
    public void transactions_table_should_have_column_names(List<String> expectedHeads) {

        List<String> actualHeads = BrowserUtils.getElementsText(accountActivityPage.tableheads);
        Assert.assertEquals(expectedHeads,actualHeads);

    }

}
