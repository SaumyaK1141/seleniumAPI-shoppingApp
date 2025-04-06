package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;

	// Locators for cart page elements
	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	WebElement backpackProduct;

	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")
	WebElement bikeLightProduct;

	// Constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize the elements
	}

	// Simplified method to verify if both products are in the cart
	public boolean areBothProductsInCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Check if both products are visible
		boolean isBackpackVisible = wait.until(ExpectedConditions.visibilityOf(backpackProduct)) != null;
		boolean isBikeLightVisible = wait.until(ExpectedConditions.visibilityOf(bikeLightProduct)) != null;

		return isBackpackVisible && isBikeLightVisible; // Return true if both products are visible
	}

	// Method to proceed to checkout
	public CheckoutPage proceedToCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		checkoutButton.click();

		// Wait for the Checkout page to load (or use another condition to detect page
		// load)
		WebDriverWait waitForCheckoutPage = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitForCheckoutPage.until(ExpectedConditions.urlContains("checkout"));
		return new CheckoutPage(driver);
	}
}
