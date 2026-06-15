package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    By addToCart = By.cssSelector(".inventory_item button");
    By cart = By.className("shopping_cart_link");

    public void addProduct() {
        getDriver().findElement(addToCart).click();
    }

    public void goToCart() {
        getDriver().findElement(cart).click();
    }
}