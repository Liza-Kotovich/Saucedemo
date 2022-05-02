package org.tms.page;

import groovy.util.logging.Log4j;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@Log4j2
public class InventoryPage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfMainPageSection;

    public String getTextOfNameOfMainPageSection() {
        log.info("Get text of name of main page section at the page");
        return nameOfMainPageSection.getText();
    }

    @FindBy(xpath = "//button[contains(@id,'add-to-cart')]")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement indicatorOfCart;

    @FindBy(xpath = "//button[contains(@id, 'remove')]")
    private List<WebElement> removeItemFromCartButton;

    public void clickAddToCartButtonByIndex(int index) {
        log.info("Click to button for add to cart item");
        addToCartButton.get(index).click();
    }

    public String getTextOfNumberThingsInCart() {
        log.info("Getting number of items in the cart");
        return indicatorOfCart.getAttribute("innerText");
    }

    public void clickRemoveItemFromCartButtonByIndex(int index) {
        log.info("Removing item from the cart");
        removeItemFromCartButton.get(index).click();
    }

}

