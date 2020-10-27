package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTransactionStepDef {

    FindTransactionPage findTransactionPage = new FindTransactionPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String tab) {

        BrowserUtils.clickWithJS(accountActivityPage.findTransactionTab);

    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {


        findTransactionPage.fromDateBox.sendKeys(fromDate);
        findTransactionPage.toDateBox.sendKeys(toDate);

    }


    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.clickWithJS(findTransactionPage.findButton);
        BrowserUtils.waitFor(2);

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) throws ParseException {

        //  findTransactionPage.compareDateRows(fromDate,toDate);
        findTransactionPage.compareDatesWithinDateRange(fromDate, toDate);


    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        findTransactionPage.sortOfDates();

    }


    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {

        findTransactionPage.isdateRows02_06ContainsDate(date);

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {

        findTransactionPage.descriptionBox.sendKeys(description);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        findTransactionPage.hasreultTableDescription(description);


    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {

        findTransactionPage.resultTableHasNotDescription(description);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String columnName) {
        findTransactionPage.getColumnResultFromResultTable(columnName);

    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String columnName) {
        findTransactionPage.noResultUnderTransctionType(columnName);

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {
        findTransactionPage.selectType(type);

    }

}
