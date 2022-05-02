package org.tms.page;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Log4j2

public class LoginPage extends Page {
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButton;

    public LoginPage openPage(String url) {
        log.info("Opening page from url");
        driver.get(url);
        return this;
    }

    public LoginPage fillInUsername(String userName) {
        log.info("Input username");
        username.clear();
        username.sendKeys(userName);
        return this;
    }

    public LoginPage fillInPassword(String keyPassword) {
        log.info("Input password");
        password.clear();
        password.sendKeys(keyPassword);
        return this;
    }

    public void clickLoginButton() {
        log.info("Click on the login button");
        loginButton.click();
    }

}

