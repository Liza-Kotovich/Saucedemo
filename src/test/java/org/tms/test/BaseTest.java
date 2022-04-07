package org.tms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.tms.driver.DriverSingleton;
import org.tms.page.InventoryPage;
import org.tms.service.LoginPageService;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }


    @AfterTest
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
