package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("[data-test='error']");

    public void open() {
        getDriver().get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        getDriver().findElement(username).clear();
        getDriver().findElement(username).sendKeys(user);
        getDriver().findElement(password).clear();
        getDriver().findElement(password).sendKeys(pass);
        getDriver().findElement(loginBtn).click();
    }

    public boolean isErrorDisplayed() {
        return getDriver().findElement(errorMsg).isDisplayed();
    }
}