package hooks;

import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static Scenario scenario;

	@Before
	public void beforeScenario(Scenario sc) {
		scenario = sc;
	}

	@After
	public void afterScenario() {
		// optional cleanup
	}

	public static void log(String message) {
		if (scenario != null) {
			scenario.log(message);
		}
	}

	public static void assertTrue(boolean condition, String message) {
		try {
			Assert.assertTrue(condition, message);
			log("✅ " + message);
		} catch (AssertionError e) {
			log("❌ " + message);
			throw e;
		}
	}

	public static void assertNotNull(Object object, String message) {
		try {
			Assert.assertNotNull(object, message);
			log("✅ " + message);
		} catch (AssertionError e) {
			log("❌ " + message);
			throw e;
		}
	}

	public static void assertEquals(Object expected, Object actual, String message) {
		try {
			Assert.assertEquals(actual, expected, message);
			log("✅ " + message);
		} catch (AssertionError e) {
			log("❌ " + message);
			throw e;
		}

	}

}
