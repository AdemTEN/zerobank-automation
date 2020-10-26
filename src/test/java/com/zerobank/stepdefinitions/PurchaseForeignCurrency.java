package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrency {

    PayBillsPage payBillsPage = new PayBillsPage();
    @Then("following currencies should be available")
    public void following_currencies_should_be_available( List<String> expectedCurrencyOptions) {

        Select currencyDropdown = payBillsPage.getCurrencyOptionList();
        List<WebElement> currencyptions = currencyDropdown.getOptions();

        List<String> actualCurrencyOptions = BrowserUtils.getElementsText(currencyptions);
        System.out.println("actualCurrencyOptions = " + actualCurrencyOptions);
        System.out.println("expectedCurrencyOptions = " + expectedCurrencyOptions);
        Assert.assertEquals(expectedCurrencyOptions,actualCurrencyOptions);
    }


    @When("user tries to calculate cost without selecting a currency and click on purchase button")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

      BrowserUtils.clickWithJS(payBillsPage.purchaseButton);

    }

    @Then("error message on popup {string} should be displayed")
    public void error_message_on_popup_should_be_displayed(String message) {
        payBillsPage.errorMessage(message);
    }

    @Then("Select {string} from the currency")
    public void select_from_the_currecy(String currency) {
        payBillsPage.selectCurrency(currency);


    }



    @When("user tries to calculate cost without entering a value and click on purchase button")
    public void user_tries_to_calculate_cost_without_entering_a_value_and_click_on_purchase_button() {
        BrowserUtils.clickWithJS(payBillsPage.purchaseButton);
    }






}
