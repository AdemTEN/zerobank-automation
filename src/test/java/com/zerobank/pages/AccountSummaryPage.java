package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class AccountSummaryPage extends BasePage {

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTaypes;

    @FindBy(xpath = "(//table[@class='table'])[3]//tr/th")
    public List<WebElement> creditAccountsColumns;

    //get Account Types
    public void getAccountTypes(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(accountTaypes);
        System.out.println("expectedAccountTypes = " + expectedAccountTypes);
        System.out.println("actualAccountTypes = " + actualAccountTypes);
        Assert.assertEquals(expectedAccountTypes, actualAccountTypes);
    }


    //get Creadit Accounts table heads
    public void getTableHeader(List<String> expectedCreditAccountsColumns) {
        List<String> actual = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("(//table[@class='table'])[3]//tr/th")));
        System.out.println("actual = " + actual);
        System.out.println("expectedCreditAccountsColumns = " + expectedCreditAccountsColumns);
        Assert.assertEquals(actual, expectedCreditAccountsColumns);
    }

}
