package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    public ProductPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void addProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCart)).click();

        // pastikan masuk cart
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
    }

    public void goToCart() {
    wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();

    // tunggu masuk cart
    wait.until(ExpectedConditions.urlContains("cart"));
}
}