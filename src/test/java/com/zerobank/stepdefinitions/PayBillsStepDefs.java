package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayBillsStepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();


    @Then("user should be able to complete payment")
    public void after_user_completes_pay_operation() {
        payBillsPage.completePayment();
    }

    @Then("the message {string} should be displayed")
    public void the_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage,payBillsPage.submittedMessage.getText());
        Assert.assertTrue(payBillsPage.submittedMessage.isDisplayed());
    }



   @Then("the warning message {string} in the the {string} should be displayed")
   public void the_warning_message_in_the_the_should_be_displayed(String expectedWarningMessage, String inputBoxName) {
      payBillsPage.getWarningMessage(expectedWarningMessage,inputBoxName);
   }



    @Then("the user try to make payment without {string}")
    public void the_user_try_to_make_payment_without(String input) {
        payBillsPage.paymentWithoutInput(input);

    }

    @Then("the user enter special or alphabetical character as {string}")
    public void the_user_enter_special_or_alphabetical_character_as(String input) {
        payBillsPage.enterAnyCharWithoutNumbersAmountAndDateInputBox(input);

    }



    @Then("the payment message shouldn't be displayed")
    public void the_payment_message_shouldn_t_be_displayed() {
        Assert.assertFalse(payBillsPage.submittedMessage.isDisplayed());

    }



    @Then("the {string} should not accept any character without numbers")
    public void the_should_not_accept_any_character_without_numbers(String boxName) {
        payBillsPage.isInputBoxAcceptAlphabeticalChar(boxName);

    }



}
