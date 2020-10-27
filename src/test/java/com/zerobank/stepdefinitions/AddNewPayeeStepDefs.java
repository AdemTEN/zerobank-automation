package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();


    @Then("click on {string} tab")
    public void click_on_tab(String tab) {

        payBillsPage.clickOnTab(tab).click();


    }

    @Then("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> payeeInfo) {

        payBillsPage.createNewPayee(payeeInfo.get("Payee Name"), payeeInfo.get("Payee Address")
                , payeeInfo.get("Account"), payeeInfo.get("Payee details"));


    }

    @Then("message The new payee {string} should be displayed")
    public void message_The_new_payee_was_successfully_created_should_be_displayed(String message) {

        Assert.assertEquals(message, payBillsPage.newPayeeMessage.getText());

    }
}
