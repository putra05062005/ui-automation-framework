package pages;

import org.openqa.selenium.By;

public class CartPage extends BasePage {

    By checkout = By.id("checkout");

    public void clickCheckout() {
        getDriver().findElement(checkout).click();
    }
}