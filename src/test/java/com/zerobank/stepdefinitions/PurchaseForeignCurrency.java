package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrency {

    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedCurrencyOptions) {

        payBillsPage.verifyCurrencyOptionList(expectedCurrencyOptions);

    }

    @When("user tries to calculate cost without enter a {string} and click on purchase button")
    public void user_tries_to_calculate_cost_without_enter_a_and_click_on_purchase_button(String currencyOrAmount) {

        payBillsPage.enterCurrencyOrAmount(currencyOrAmount);


    }


    @Then("error message on popup {string} should be displayed")
    public void error_message_on_popup_should_be_displayed(String message) {
        payBillsPage.errorMessage(message);
    }


    @When("user tries to calculate cost without entering a value and click on purchase button")
    public void user_tries_to_calculate_cost_without_entering_a_value_and_click_on_purchase_button() {
        BrowserUtils.clickWithJS(payBillsPage.calculateCostButton);
    }


}
