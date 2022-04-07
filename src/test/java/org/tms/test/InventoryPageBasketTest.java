package org.tms.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.page.InventoryPage;
import org.tms.service.InventoryPageService;
import org.tms.service.LoginPageService;

public class InventoryPageBasketTest extends BaseTest {
    private static int firstItem = 0;
    private InventoryPageService inventoryPageService = new InventoryPageService();

    @Test
    public void addToCartTest() {
        inventoryPageService.login();
        String initialNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
        String expectedNumberOfItemsInTheCart = getExpectedNumberOfIremsInCartAfterAdding(initialNumberOfItemsInCart);
        inventoryPageService.addToCartItem(firstItem);
        String actualNumberOfItemsInTheCart = inventoryPageService.getNumberOfItemsInCart();
        Assert.assertEquals(actualNumberOfItemsInTheCart, expectedNumberOfItemsInTheCart, "The actual number of items in the cart does not match expected!");
    }

    @Test(dependsOnMethods = "addToCartTest")
    public void removeFromCartTest() {
        String initialNumberOfItemsInCart = inventoryPageService.getNumberOfItemsInCart();
        String expectedNumberOfItemsInCart = getExpectedNumberOfItemsInCartAfterRemoval(initialNumberOfItemsInCart);
        inventoryPageService.removeItemFromCart(firstItem);
        String actualNumberOfItemsInCart = getActualNumberOfItemsInCartAfterRemoval(inventoryPageService.getNumberOfItemsInCart());
        Assert.assertEquals(actualNumberOfItemsInCart, expectedNumberOfItemsInCart, "Number of added things doesn't match!");
    }


    private String getExpectedNumberOfIremsInCartAfterAdding(String numberOfItemsinCart) {
        if (numberOfItemsinCart.equals("")) {
            return "1";
        } else {
            return
                    Integer.toString(Integer.parseInt(numberOfItemsinCart) + 1);
        }
    }

    private String getExpectedNumberOfItemsInCartAfterRemoval(String numberOfItemsInCart) {
        return Integer.toString(Integer.parseInt(numberOfItemsInCart) - 1);
    }

    private String getActualNumberOfItemsInCartAfterRemoval(String numberOfItemsInCart) {
        if (numberOfItemsInCart.equals("")) {
            return "0";
        } else {
            return numberOfItemsInCart;
        }
    }

}

