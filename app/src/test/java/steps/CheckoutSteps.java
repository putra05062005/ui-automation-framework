package steps;

import io.cucumber.java.en.*;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutSteps {

    LoginPage login = new LoginPage();
    ProductPage product = new ProductPage();
    CartPage cart = new CartPage();
    CheckoutPage checkout = new CheckoutPage();

    @Given("user login ke saucedemo")
    public void loginSauce() {
        login.open();
        login.login("standard_user", "secret_sauce");
        assertTrue(login.isLoginSuccess());
    }

    @When("user melakukan checkout produk")
    public void checkoutFlow() {
        product.addProduct();
        product.goToCart();
        cart.clickCheckout();

        checkout.fillForm();
        checkout.continueCheckout();
        checkout.finishCheckout();
    }

    @Then("checkout berhasil")
    public void success() {
        assertTrue(checkout.isCheckoutSuccess());
    }
}