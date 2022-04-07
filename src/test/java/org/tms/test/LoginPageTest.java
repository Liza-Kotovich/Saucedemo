package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class LoginPageTest extends BaseTest {

    LoginPageService loginPageService = new LoginPageService();
    InventoryPage inventoryPage = loginPageService.login();

    @Test
    public void loginTest() {

        String actualTextOfInventoryPage = inventoryPage.getTextOfNameOfMainPageSection();
        String expectedPageText = "PRODUCTS";
        Assert.assertEquals(actualTextOfInventoryPage, expectedPageText, "The actual text of the page does not match expected!");
    }

}

