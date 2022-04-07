package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends Page {
    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    public String getTextOfNameOfMainPageSection() {
        return nameOfMainPageSection.getText();
    }

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement indicatorOfCart;

    @FindBy(xpath = "//button[contains(@id, 'remove')]")
    private List<WebElement> removeItemFromCartButton;

    public void clickAddToCartButtonByIndex(int index) {
        addToCartButton.get(index).click();
    }

    public String getTextOfNumberThingsInCart() {
        return indicatorOfCart.getAttribute("innerText");
    }

    public void clickRemoveItemFromCartButtonByIndex(int index) {
        removeItemFromCartButton.get(index).click();
    }

}

