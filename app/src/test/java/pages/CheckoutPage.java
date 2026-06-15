package pages;

import org.openqa.selenium.*;

public class CheckoutPage {

    WebDriver driver;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public CheckoutPage() {
        this.driver = DriverManager.getDriver();
    }

    public void fillForm() {
        driver.findElement(firstName).sendKeys("Pahala");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(postalCode).sendKeys("12345");
    }

    public void continueCheckout() {
        driver.findElement(continueBtn).click();
    }

    public void finishCheckout() {
        driver.findElement(finishBtn).click();
    }
    By successMessage = By.className("complete-header");

    public boolean isCheckoutSuccess() {
        try {
        return driver.findElement(successMessage)
                     .getText()
                     .contains("Thank you");
    } catch (Exception e) {
        return false;
    }
}
}