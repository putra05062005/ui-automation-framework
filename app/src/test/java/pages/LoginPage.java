package pages;

import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.cssSelector("button[type='submit']");
    By successMsg = By.id("flash");

    public LoginPage() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // 🔥 FIX CI
        options.setBinary("/usr/bin/google-chrome");

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-gpu");

        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void inputUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void inputPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public String getMessage() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(successMsg)
        ).getText();
    }

    public void close() {
        driver.quit();
    }
}