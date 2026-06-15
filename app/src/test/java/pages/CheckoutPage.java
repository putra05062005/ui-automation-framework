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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25)); // 🔥 tambah waktu
    }

    public void fillForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys("Pahala");
        driver.findElement(lastName).sendKeys("Test");
        driver.findElement(postalCode).sendKeys("12345");
    }

    public void continueCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

        //tunggu pindah ke step 2
        wait.until(ExpectedConditions.urlContains("checkout-step-two"));
    }

    public void finishCheckout() {
        //pastikan tombol muncul dulu
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn));

        //retry click (anti flaky)
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
                break;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        }

        // tunggu redirect ke success page
        wait.until(ExpectedConditions.urlContains("checkout-complete"));
    }

    public boolean isCheckoutSuccess() {
        try {
            wait.until(ExpectedConditions.urlContains("checkout-complete"));

            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMsg)
            ).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
}