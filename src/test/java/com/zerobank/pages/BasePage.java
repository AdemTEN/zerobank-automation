package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    // @FindBy(xpath = "//a[contains(text(),'Account Summary')]")
    //  public WebElement pageName;

    //get page name
    public WebElement getPageName(String pageName) {
        String xpath = "//a[contains(text(),'" + pageName + "')]";
        return Driver.get().findElement(By.xpath(xpath));
    }


}
