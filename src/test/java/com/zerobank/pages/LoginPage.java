package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@type='text'][contains(@id,'login')]")
    public WebElement userName;

    @FindBy(css = "#user_password")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[contains(@type,'submit')]")
    public WebElement submit;

    @FindBy(xpath = "//div[@class='alert alert-error'][contains(.,'Login and/or password are wrong.')]")
    public WebElement message;

    @FindBy(xpath = "//button[contains(@type,'button')]")
    public WebElement signinButton;

    public void onLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    public void loginWithValidCredentials() {
        BrowserUtils.clickWithJS(signinButton);
        BrowserUtils.waitFor(1);
        String usernameStr = ConfigurationReader.get("username");
        String passwordStr = ConfigurationReader.get("password");
        userName.sendKeys(usernameStr);
        passwordBox.sendKeys(passwordStr);
        submit.click();

    }

    public void loginWithWrongCredentials(String username, String password) {
        BrowserUtils.waitFor(1);
        BrowserUtils.clickWithJS(signinButton);
        userName.sendKeys(username);
        passwordBox.sendKeys(password);
        submit.click();
    }
}
