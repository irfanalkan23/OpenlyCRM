package com.OpenlyCRM.pages;

import com.OpenlyCRM.utilities.BrowserUtils;
import com.OpenlyCRM.utilities.ConfigurationReader;
import com.OpenlyCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "USER_LOGIN")
    public WebElement usernameBox;

    @FindBy(name = "USER_PASSWORD")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@class='login-btn']")
    public WebElement loginButton;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("OpenlyCRM.url"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));;
        passwordBox.sendKeys(ConfigurationReader.getProperty("pw"));
        //loginButton.click();
        BrowserUtils.clickWithJS(loginButton);
    }
}
