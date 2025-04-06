package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", // Path to your .feature files
		glue = { "StepDefinations", "hooks" }, plugin = { "pretty", "html:target/cucumber-reports.html",
				"json:target/cucumber.json" })
public class TestRunner extends AbstractTestNGCucumberTests {

}