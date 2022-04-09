package org.tms.service;

import org.tms.page.InventoryPage;

public class InventoryPageService {

    private InventoryPage inventoryPage;
    private LoginPageService loginPageService = new LoginPageService();

    public InventoryPageService login(){
        inventoryPage = loginPageService.login();
        return this;
    }

    public InventoryPageService addToCartItem(int itemIndex){
        inventoryPage.clickAddToCartButtonByIndex(itemIndex);
        return this;
    }
    public InventoryPageService removeItemFromCart(int itemIndex){
        inventoryPage.clickRemoveItemFromCartButtonByIndex(itemIndex);
        return this;
    }
    public String getNumberOfItemsInCart(){
        return inventoryPage.getTextOfNumberThingsInCart();
    }
}
