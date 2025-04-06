package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;

	// Locators for checkout page elements
	@FindBy(id = "first-name")
	WebElement firstNameField;

	@FindBy(id = "last-name")
	WebElement lastNameField;

	@FindBy(id = "postal-code")
	WebElement postalCodeField;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(id = "finish")
	WebElement finishButton;

	@FindBy(xpath = "//span[@class='title']")
	private WebElement CheckoutComplete;

	// Constructor
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize the elements
	}

	// Method to complete the checkout
	public ConfirmationPage completeCheckout(String firstName, String lastName, String postalCode) {
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		postalCodeField.sendKeys(postalCode);
		continueButton.click();
		finishButton.click();
		return new ConfirmationPage(driver);
	}

	public WebElement getCheckoutComplete() {
		return CheckoutComplete;
	}

}
