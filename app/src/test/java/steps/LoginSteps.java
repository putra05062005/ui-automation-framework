package steps;

import io.cucumber.java.en.*;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    LoginPage login = new LoginPage();

    @Given("user membuka website")
    public void open() {
        login.open();
    }

    @When("user login dengan username {string} dan password {string}")
    public void loginStep(String user, String pass) {
        login.login(user, pass);
    }

    @Then("user berhasil login")
    public void success() {
        assertTrue(login.isLoginSuccess());
    }

    @Then("user gagal login")
    public void fail() {
        assertTrue(login.isErrorDisplayed());
    }

    @Then("user melihat error login")
    public void empty() {
        assertTrue(login.isErrorDisplayed());
    }
}