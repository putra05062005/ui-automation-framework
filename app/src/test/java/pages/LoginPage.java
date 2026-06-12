package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By message = By.id("flash");

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

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void inputUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void inputPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(message)
        ).getText();
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}