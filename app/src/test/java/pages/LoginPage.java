package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // 🔹 Locator (SAUCEDEMO)
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMessage = By.cssSelector("[data-test='error']");
    By inventoryPage = By.className("inventory_list");

    //  Constructor
    public LoginPage() {

        ChromeOptions options = new ChromeOptions();

        boolean isCI = System.getenv("CI") != null;

        if (isCI) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        }

        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //  Open website
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    //  Input username
    public void inputUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    //  Input password
    public void inputPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    //  Click login
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    //  Shortcut login
    public void login(String user, String pass) {
        inputUsername(user);
        inputPassword(pass);
        clickLogin();
    }

    //  Validasi login berhasil
    public boolean isLoginSuccess() {
        try {
            return wait.until(
                ExpectedConditions.visibilityOfElementLocated(inventoryPage)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    //  FIX ERROR KAMU (WAJIB ADA)
    public boolean isErrorDisplayed() {
        try {
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // 🔹 Close browser
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}