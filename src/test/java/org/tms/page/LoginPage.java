package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInUsername(String userName) {
        username.clear();
        username.sendKeys(userName);
        return this;
    }

    public LoginPage fillInPassword(String keyPassword) {
        password.clear();
        password.sendKeys(keyPassword);
        return this;
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}

