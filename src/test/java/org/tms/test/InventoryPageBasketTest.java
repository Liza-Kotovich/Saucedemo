package org.tms.test;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.tms.driver.DriverSingleton;
import org.tms.service.InventoryPageService;

public class InventoryPageBasketTest extends BaseTest {

    private static int firstItem = 0;

    InventoryPageService inventoryPageService = new InventoryPageService();

    @AfterMethod
    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Test(description = "Add to cart test")
    public void addToCartTest() {
        inventoryPageService.login();
        String initialNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
        String expectedNumberOfItemsInTheCart = getExpectedNumberOfItemsInCartAfterAdding(initialNumberOfItemsInCart);
        inventoryPageService.addToCartItem(firstItem);
        String actualNumberOfItemsInTheCart = inventoryPageService.getNumberOfItemsInCart();
        Assert.assertEquals(actualNumberOfItemsInTheCart, expectedNumberOfItemsInTheCart, "The actual number of items in the cart does not match expected!");
    }

    @Test(dependsOnMethods = "addToCartTest", description = "Remove from cart test")
    public void removeFromCartTest() {
        String initialNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
        String expectedNumberOfItemsInCart = getExpectedNumberOfItemsInCartAfterRemoval(initialNumberOfItemsInCart);
        inventoryPageService.removeItemFromCart(firstItem);
        String actualNumberOfItemsInCart = getActualNumberOfItemsInCartAfterRemoval(inventoryPageService.getNumberOfItemsInCart());
        Assert.assertEquals(actualNumberOfItemsInCart, expectedNumberOfItemsInCart, "Number of added things doesn't match!");
    }

    @Attachment
    private String getExpectedNumberOfItemsInCartAfterAdding(String numberOfItemsInCart) {
        if (numberOfItemsInCart.equals("")) {
            return "1";
        } else {
            return
                    Integer.toString(Integer.parseInt(numberOfItemsInCart) + 1);
        }
    }

    @Attachment
    private String getExpectedNumberOfItemsInCartAfterRemoval(String numberOfItemsInCart) {
        return Integer.toString(Integer.parseInt(numberOfItemsInCart) - 1);
    }

    @Attachment
    private String getActualNumberOfItemsInCartAfterRemoval(String numberOfItemsInCart) {
        if (numberOfItemsInCart.equals("")) {
            return "0";
        } else {
            return numberOfItemsInCart;
        }
    }

}

