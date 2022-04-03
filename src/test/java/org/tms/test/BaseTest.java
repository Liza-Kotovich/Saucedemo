package org.tms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.tms.driver.DriverSingleton;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}
