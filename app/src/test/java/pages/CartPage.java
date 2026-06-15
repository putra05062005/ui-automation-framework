package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    By checkoutBtn = By.id("checkout");

    public CartPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void clickCheckout() {

        //  tunggu URL cart 
        wait.until(ExpectedConditions.urlContains("cart"));

        //  tombol muncul & clickable
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();

        //  tunggu pindah ke checkout step 1
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));
    }
}