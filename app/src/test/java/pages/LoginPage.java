package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // 🔹 Locator
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By message = By.id("flash");

    // 🔥 Constructor (driver setup di sini)
    public LoginPage() {

        ChromeOptions options = new ChromeOptions();

        // 🔥 MODE TOGGLE (BEST PRACTICE)
        boolean isHeadless = Boolean.parseBoolean(
            System.getProperty("headless", "false")
        );

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
        }

        // 🔥 INIT DRIVER
        driver = new ChromeDriver(options);

        // 🔥 WAIT
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔹 Open page
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // 🔹 Input username
    public void inputUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    // 🔹 Input password
    public void inputPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    // 🔹 Click login
    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    // 🔹 Get message
    public String getMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(message)
        ).getText();
    }

    // 🔹 Close browser
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}