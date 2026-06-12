package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("saya membuka halaman login")
    public void openLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    @When("saya memasukkan username dan password yang benar")
    public void inputValid() {
        loginPage.inputUsername("tomsmith");
        loginPage.inputPassword("SuperSecretPassword!");
    }

    @When("saya memasukkan username dan password yang salah")
    public void inputInvalid() {
        loginPage.inputUsername("wrong");
        loginPage.inputPassword("wrong");
    }

    @And("saya klik tombol login")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("saya berhasil login")
    public void success() {

        String msg = loginPage.getMessage();
        System.out.println(msg);

        if (!msg.contains("You logged into a secure area!")) {
            throw new AssertionError("Login gagal padahal harusnya berhasil");
        }

        driver.quit();
    }

    @Then("muncul pesan error")
    public void error() {

        String msg = loginPage.getMessage();
        System.out.println(msg);

        if (!msg.contains("Your username is invalid!")) {
            throw new AssertionError("Error tidak muncul");
        }

        driver.quit();
    }
}