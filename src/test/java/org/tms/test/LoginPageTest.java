package org.tms.test;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.tms.driver.DriverSingleton;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class LoginPageTest extends BaseTest {

    LoginPageService loginPageService = new LoginPageService();
    InventoryPage inventoryPage = loginPageService.login();

    @AfterMethod
    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Test(description = "Login test")
    public void loginTest() {
        String actualTextOfInventoryPage = inventoryPage.getTextOfNameOfMainPageSection();
        String expectedPageText = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedPageText, "The actual text of the page does not match expected!");
    }

}

