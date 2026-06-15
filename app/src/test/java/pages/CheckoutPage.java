package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public void fillData() {
        getDriver().findElement(firstName).sendKeys("Pahala");
        getDriver().findElement(lastName).sendKeys("Test");
        getDriver().findElement(zip).sendKeys("12345");
    }

    public void finishCheckout() {
        getDriver().findElement(continueBtn).click();
        getDriver().findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).getText();
    }
}