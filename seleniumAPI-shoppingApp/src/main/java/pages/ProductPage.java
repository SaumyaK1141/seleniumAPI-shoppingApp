package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;

	// Locators for product elements
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement product1AddButton;

	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement product2AddButton;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	WebElement cartButton;

	// Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize the elements
	}

	// Method to add products to the cart
	public void addProductsToCart() {
		product1AddButton.click();
		product2AddButton.click();
	}

	public CartPage goToCart() {
		cartButton.click();
		return new CartPage(driver);
	}
}