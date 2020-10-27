package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(xpath = "//select[contains(@name,'accountId')]")
    public WebElement accountOptions;

    public Select accountOptionList() {
        return new Select(accountOptions);
    }

    @FindBy(xpath = "//thead//th")
    public List<WebElement> tableheads;

    //  @FindBy(xpath = "//a[contains(.,'Brokerage')]")
    //  public WebElement accountlinks;

    public WebElement getlinks(String link) {
        String xpath = "//a[contains(.,'" + link + "')]";
        return Driver.get().findElement(By.xpath(xpath));

    }

    @FindBy(xpath = "//a[contains(.,'Find Transactions')]")
    public WebElement findTransactionTab;

    public WebElement getTab(String tab) {
        String xpath = "//a[contains(.,'" + tab + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }

}
