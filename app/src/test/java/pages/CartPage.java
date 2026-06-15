package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By checkoutBtn = By.id("checkout");
    By cartItem = By.className("cart_item");

    public CartPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickCheckout() {

        wait.until(ExpectedConditions.urlContains("cart"));

        // pastikan ada item
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItem));

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();

        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }
}