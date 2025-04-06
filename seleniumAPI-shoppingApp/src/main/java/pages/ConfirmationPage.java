package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
	WebDriver driver;

	// Locators for confirmation page
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	WebElement confirmationMessage;

	// Constructor
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize the elements
	}

	// Method to verify if the checkout is successful
	public boolean isCheckoutSuccessful() {
		return confirmationMessage.getText().equals("Thank you for your order!");
	}
}
