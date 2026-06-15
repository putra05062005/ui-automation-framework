package pages;

import org.openqa.selenium.*;

public class CartPage {

    WebDriver driver;

    By checkoutBtn = By.id("checkout");

    public CartPage() {
        this.driver = DriverManager.getDriver();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}