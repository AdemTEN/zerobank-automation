package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class PayBillsPage extends BasePage {


    //Pay Saved Payee Web Elements
    @FindBy(xpath = "//select[contains(@id,'payee')][@name='payee']")
    public WebElement payee;

    @FindBy(xpath = "//select[contains(@id,'account')][@name='account']")
    public WebElement account;

    @FindBy(xpath = "//input[contains(@id,'sp_amount')]")
    public WebElement amount;

    @FindBy(xpath = "//input[contains(@id,'sp_date')]")
    public WebElement date;
    //
    @FindBy(xpath = "//input[contains(@id,'sp_description')]")
    public WebElement description;

    @FindBy(xpath = "//input[contains(@id,'pay_saved_payees')]")
    public WebElement payButton;

    @FindBy(xpath = "//div[contains(@id,'content')][contains(.,'The payment was successfully submitted.')]")
    public WebElement submittedMessage;

    //tabs of Pay Bills page
    @FindBy(xpath = "//a[contains(.,'Add New Payee')]")
    public WebElement pageBillsTabs;


    public WebElement clickOnTab(String tab) {
        String xpath = "//a[contains(.,'" + tab + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

    //Add new Payee Web Elements
    @FindBy(xpath = "//input[@type='text'][contains(@id,'name')]")
    public WebElement payeeNameBox;

    @FindBy(xpath = "//textarea[contains(@name,'address')]")
    public WebElement addressBox;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'account')]")
    public WebElement accountBox;

    @FindBy(xpath = "//input[@type='text'][contains(@id,'details')]")
    public WebElement payeeDetailsBox;

    @FindBy(xpath = "//input[contains(@value,'Add')]")
    public WebElement addButton;

    @FindBy(xpath = "//div[contains(@id,'content')][contains(.,'The new payee The Law Offices of Hyde, Price & Scharks was successfully created.')]")
    public WebElement newPayeeMessage;


    public void createNewPayee(String name, String address, String account, String details) {

        payeeNameBox.sendKeys(name);
        addressBox.sendKeys(address);
        accountBox.sendKeys(account);
        payeeDetailsBox.sendKeys(details);
        addButton.click();

    }

    //Purchase Foreign Currency Web Element
    @FindBy(xpath = "//select[contains(@name,'currency')]")
    public WebElement currencyOptions;

    @FindBy(xpath = "//input[contains(@id,'pc_amount')]")
    public WebElement amountInputBox;

    public Select getCurrencyOptionList() {
        return new Select(currencyOptions);
    }

    @FindBy(xpath = "//input[@type='button'][contains(@id,'costs')]")
    public WebElement calculateCostButton;


    //user tries to calculate cost without enter a "Currency"  or "Amount" and click on purchase button
    public void enterCurrencyOrAmount(String currencyOrAmount) {
        if (currencyOrAmount.equals("Currency")) {
            amountInputBox.sendKeys("3000");
        } else if (currencyOrAmount.equals("Amount")) {
            Select currencyDropdown = new Select(currencyOptions);
            currencyDropdown.selectByVisibleText("Canada (dollar)");
        }
        BrowserUtils.clickWithJS(calculateCostButton);
    }


    public void verifyCurrencyOptionList(List<String> expectedCurrencyOptions) {
        Select currencyDropdown = getCurrencyOptionList();
        List<WebElement> currencyOptions = currencyDropdown.getOptions();
        List<String> actualCurrencyOptions = new ArrayList<>();

        for (WebElement currencyOption : currencyOptions) {
            if (!currencyOption.getText().equals("Select One")) {
                actualCurrencyOptions.add(currencyOption.getText());
            }
        }
        Assert.assertEquals(expectedCurrencyOptions, actualCurrencyOptions);
        System.out.println("actualCurrencyOptions = " + actualCurrencyOptions);
        System.out.println("expectedCurrencyOptions = " + expectedCurrencyOptions);


    }


    public void errorMessage(String expectedMessage) {
        Alert alert = Driver.get().switchTo().alert();
        String actualMessage = alert.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        alert.accept();


    }


    public void completePayment() {
        Select payeeDropdown = new Select(payee);
        payeeDropdown.selectByVisibleText("Sprint");

        Select accountDropdown = new Select(account);
        accountDropdown.selectByVisibleText("Credit Card");

        amount.sendKeys("3000");
        date.sendKeys("2020-05-25");
        description.sendKeys("Shopping");
        BrowserUtils.clickWithJS(payButton);

    }

    //payment without amount and date
    public void paymentWithoutInput(String input) {
        Select payeeDropdown = new Select(payee);
        payeeDropdown.selectByVisibleText("Sprint");

        Select accountDropdown = new Select(account);
        accountDropdown.selectByVisibleText("Credit Card");
        if (input.equals("amount")) {
            date.sendKeys("2020-05-25");
        } else if (input.equals("date")) {
            amount.sendKeys("3000");
        }

        description.sendKeys("Shopping");
        BrowserUtils.clickWithJS(payButton);


    }


    //can catch this exception message like this
    public void getWarningMessage(String expectedWarningMessage, String inputBoxName) {
        //String actualWarningMessage = Driver.get().findElement(By.xpath("//input[contains(@id,'sp_amount')]")).getAttribute("validationMessage");
        String actualWarningMessage = "";
        if (inputBoxName.equals("Amount Box")) {
            actualWarningMessage = amount.getAttribute("validationMessage");
        } else if (inputBoxName.equals("Date Box")) {
            actualWarningMessage = date.getAttribute("validationMessage");
        }


        System.out.println("actualMessage = " + actualWarningMessage);
        Assert.assertEquals(expectedWarningMessage, actualWarningMessage);


    }

    public void enterAnyCharWithoutNumbersAmountAndDateInputBox(String input) {
        Select payeeDropdown = new Select(payee);
        payeeDropdown.selectByVisibleText("Sprint");

        Select accountDropdown = new Select(account);
        accountDropdown.selectByVisibleText("Credit Card");

        if (input.equals("amount")) {
            amount.sendKeys("ABabc§$%&//");
            date.sendKeys("2020-05-25");
            description.sendKeys("Shopping");


        } else if (input.equals("date")) {
            amount.sendKeys("3000");
            date.sendKeys("ABabc/(%§");

        }

    }


    public void isInputBoxAcceptAlphabeticalChar(String boxName) {
        if (boxName.equals("Amount Box")) {
            String dateValue = amount.getAttribute("value");
            int size = dateValue.length();
            Assert.assertTrue(size == 0);
            //return (size==0) ? true : false;==ternary

        } else if (boxName.equals("Date Box")) {
            String dateValue = date.getAttribute("value");
            int size = dateValue.length();
            Assert.assertTrue(size == 0);

        }
    }


}
