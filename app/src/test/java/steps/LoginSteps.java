package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    LoginPage loginPage;

    @Given("saya membuka halaman login")
    public void openLogin() {
        loginPage = new LoginPage();
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

    @When("saya memasukkan username kosong")
    public void inputEmpty() {
        loginPage.inputUsername("");
        loginPage.inputPassword("");
    }

    @And("saya klik tombol login")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("saya berhasil login")
    public void success() {
        assertTrue(loginPage.getMessage().contains("You logged into a secure area!"));
        loginPage.close();
    }

    @Then("saya gagal login")
    public void failed() {
        assertTrue(loginPage.getMessage().contains("Your username is invalid!"));
        loginPage.close();
    }

    @Then("saya melihat error kosong")
    public void empty() {
        assertTrue(loginPage.getMessage().contains("Your username is invalid!"));
        loginPage.close();
    }
}