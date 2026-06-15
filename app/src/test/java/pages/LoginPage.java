package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.DriverManager;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By inventoryPage = By.className("inventory_list");
    By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginSuccess() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(inventoryPage)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}