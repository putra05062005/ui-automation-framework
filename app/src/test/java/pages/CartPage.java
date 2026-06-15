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

    // tunggu halaman cart fix
    wait.until(ExpectedConditions.urlContains("cart"));

    // tunggu tombol bener-bener clickable 
    WebElement btn = wait.until(
        ExpectedConditions.elementToBeClickable(checkoutBtn)
    );

    // scroll ke element 
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView(true);", btn
    );

    // klik pakai JS (biar bypass issue CI)
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].click();", btn
    );

    // tunggu pindah halaman
    wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }
}