package steps;

import io.cucumber.java.en.*;
import pages.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckoutSteps {

    LoginPage login;
    ProductPage product;
    CartPage cart;
    CheckoutPage checkout;

    @Given("user login ke saucedemo")
    public void loginSauce() {
        login = new LoginPage();

        login.open();
        login.login("standard_user", "secret_sauce");

        assertTrue(login.isLoginSuccess());

        // 🔥 INIT SETELAH LOGIN
        product = new ProductPage();
    }

    @When("user melakukan checkout produk")
    public void checkoutFlow() {

        product.addProduct();
        product.goToCart();

        // init setelah pindah page
        cart = new CartPage();
        cart.clickCheckout();

        // init setelah masuk checkout
        checkout = new CheckoutPage();

        checkout.fillForm();
        checkout.continueCheckout();
        checkout.finishCheckout();
    }

    @Then("checkout berhasil")
    public void success() {
        assertTrue(checkout.isCheckoutSuccess());
    }
}