package org.tms.service;

import io.qameta.allure.Step;
import org.tms.page.InventoryPage;

public class InventoryPageService {

    private InventoryPage inventoryPage;
    private LoginPageService loginPageService = new LoginPageService();

    @Step("Log in to the site")
    public InventoryPageService login() {
        inventoryPage = loginPageService.login();
        return this;
    }

    @Step("Add to cart item")
    public InventoryPageService addToCartItem(int itemIndex) {
        inventoryPage.clickAddToCartButtonByIndex(itemIndex);
        return this;
    }

    @Step("Remove item from the cart")
    public InventoryPageService removeItemFromCart(int itemIndex) {
        inventoryPage.clickRemoveItemFromCartButtonByIndex(itemIndex);
        return this;
    }

    @Step("Get number of items in the cart")
    public String getNumberOfItemsInCart() {
        return inventoryPage.getTextOfNumberThingsInCart();
    }
}
