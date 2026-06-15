package pages;

import org.openqa.selenium.*;

public class ProductPage {

    WebDriver driver;

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");

    public ProductPage() {
        this.driver = DriverManager.getDriver();
    }

    public void addProduct() {
        driver.findElement(addToCart).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}