package StepDefinations;

import base.BaseClass;
import base.Config;
import hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.LoginPage;
import pages.ProductPage;

public class ShoppingSteps extends BaseClass {

	LoginPage login;
	ProductPage productPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	ConfirmationPage confirmationPage;

	private Scenario scenario;

	@Before
	public void beforeScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("I login to the shopping website")
	public void login_to_site() {
		initializeDriver();
		// Use the base URL from the Config class
		driver.get(Config.BASE_URL);
		login = new LoginPage(driver);
		// Use credentials from Config class
		login.login(Config.USERNAME, Config.PASSWORD);
	}

	@When("I add a few products to the cart")
	public void add_products_to_cart() {
		productPage = new ProductPage(driver);
		productPage.addProductsToCart();
		cartPage = productPage.goToCart();

	}

	@When("I proceed to checkout")
	public void proceed_to_checkout() {
		cartPage = new CartPage(driver);

		// Verify if both products are in the cart
		boolean bothProductsInCart = cartPage.areBothProductsInCart();

		Hooks.assertTrue(bothProductsInCart, " verified products are added to the cart.");
		checkoutPage = cartPage.proceedToCheckout();
	}

	@Then("I can checkout successfully")
	public void checkout_successful() {
		// Proceed to complete checkout
		confirmationPage = checkoutPage.completeCheckout("John", "Doe", "12345");
		// Get actual message from checkout complete
		String actualMessage = checkoutPage.getCheckoutComplete().getText();
		String expectedMessage = "Checkout: Complete!";
		Hooks.assertEquals(expectedMessage, actualMessage, "verified Checkout process completed successfully");
		// Assert that the confirmation message was successful
		Hooks.assertTrue(confirmationPage.isCheckoutSuccessful(), "verified Thank you for your order!");
	}

	@After
	public void tearDown() {
		// Close the driver after each scenario
		if (driver != null) {
			driver.quit();
		}
	}
}
