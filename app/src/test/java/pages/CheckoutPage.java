package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public CheckoutPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Pahala");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(postalCode).sendKeys("12345");
    }

    public void continueCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public void finishCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }

    public boolean isCheckoutSuccess() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(successMsg)
        ).isDisplayed();
    }
}