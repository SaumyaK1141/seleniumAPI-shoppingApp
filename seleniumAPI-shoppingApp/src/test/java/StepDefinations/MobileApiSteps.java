package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import base.Config;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class MobileApiSteps {

	private Response response;

	@Given("I have a mobile API")
	public void haveMobileApi() {

	}

	@When("I validate the response")
	public void validateResponse() {
		// Use Config class for the base URL and endpoint
		response = given().baseUri(Config.API_BASE_URL).when().get(Config.OBJECTS_ENDPOINT);
	}

	@Then("the status code should be 200")
	public void verifyStatusCode() {
		assertThat(response.getStatusCode(), is(200));
	}

	@Then("the name of the object with ID {string} should be {string}")
	public void verfiyNameOfTheObjectWithID(String id, String expectedName) {
		// Use JSONPath to extract the name of the object with the specified ID
		String actualName = response.jsonPath().getString("find { it.id == '" + id + "' }.name");
		Hooks.assertEquals(expectedName, actualName, "Name of the object with ID " + id);
	}
}
