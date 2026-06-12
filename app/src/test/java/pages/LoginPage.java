package pages;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By message = By.id("flash");

    public LoginPage() {

    ChromeOptions options = new ChromeOptions();

    boolean isHeadless = Boolean.parseBoolean(
        System.getProperty("headless", "false")
    );

    if (isHeadless) {
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
    }

        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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