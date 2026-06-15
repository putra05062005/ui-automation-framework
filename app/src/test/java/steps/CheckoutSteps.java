package steps;

import io.cucumber.java.en.*;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutSteps {

    LoginPage login = new LoginPage();
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();
    CheckoutPage checkout = new CheckoutPage();


    @When("user login dengan akun valid")
    public void loginStep() {
        login.login("standard_user", "secret_sauce");
    }

    @And("user memilih produk")
    public void productStep() {
        product.addProduct();
    }

    @And("user masuk ke cart")
    public void cartStep() {
        product.goToCart();
    }

    @And("user checkout")
    public void checkoutStep() {
        cart.clickCheckout();
        checkout.fillData();
        checkout.finishCheckout();
    }

    @Then("user berhasil checkout")
    public void success() {
        assertTrue(checkout.getSuccessMessage().contains("Thank you"));
    }
}