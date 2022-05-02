package org.tms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.tms.driver.DriverSingleton;
public class BaseTest{

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
