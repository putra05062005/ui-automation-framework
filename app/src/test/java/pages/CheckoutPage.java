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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // ⬅️ perbesar
    }

    public void fillForm() {
        wait.until(ExpectedConditions.urlContains("checkout-step-one"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Pahala");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastName)).sendKeys("Test");
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode)).sendKeys("12345");
    }

    public void continueCheckout() {
        WebElement btn = wait.until(
            ExpectedConditions.elementToBeClickable(continueBtn)
        );

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

        // ⬅ tunggu ke step 2
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void finishCheckout() {

        // pastikan udah di step 2
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));

        WebElement btn = wait.until(
            ExpectedConditions.elementToBeClickable(finishBtn)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", btn
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", btn
        );

        // menunggu halaman success
        wait.until(ExpectedConditions.urlContains("checkout-complete"));
    }

    public boolean isCheckoutSuccess() {
        try {
            return wait.until(
                ExpectedConditions.or(
                    ExpectedConditions.urlContains("checkout-complete"),
                    ExpectedConditions.visibilityOfElementLocated(successMsg)
                )
            ) != null;
        } catch (Exception e) {
            return false;
        }
    }
}