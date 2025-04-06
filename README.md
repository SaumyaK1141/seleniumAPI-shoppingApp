## Project

This is a test automation framework built with Selenium, Cucumber, TestNG, RestAssured, and Java. It supports both UI and API testing, uses Page Object Model (POM) with PageFactory, and is built using Maven for dependency management.

Project Structure
	­ src/test/resources: Contains feature files and driver binaries.
	­ src/test/java: Contains step definitions, test runner, and Hooks classes for automation.
	­ src/main/java: Contains Base and Pages  classes for automation.
	­ testng.xml: TestNG suite configuration file.

## Prerequisites
	­ Java 17 or above installed.
	­ Latest Eclipse IDE with Maven support.
	­ Chrome Browser (Version 135): Ensure the latest version of Chrome browser is installed to run tests.

## Running the Project in Eclipse

 # Option 1: Running from Eclipse 
 
	­ Import the Project into Eclipse:
	­ In Eclipse, go to File → Import → Maven → Existing Maven Projects.
	­ Select your project directory.
	­ Running the TestNG Suite:
	­ Right-click on the testng.xml file located in the project directory.
	­ Select Run As → TestNG Suite.
->This will execute the test suite defined in the testng.xml file.

 ##Option 2: Running from Command Line Using Maven 
   Check Maven installation by running mvn -v in your command line. If not, download and install Maven.
   Navigate to the Project Directory: In your command line, navigate to your project folder.
      Run Tests with Maven:
      Use the following command to run tests:
      bash
      mvn clean test -DsuiteXmlFile=testng.xml

##Viewing Test Results: 

	­ After running the tests, navigate to the target folder in the project directory.
	­ Locate the Cucumber HTML report: target/cucumber-report.html.
	­ Open the cucumber-report.html file in a browser to view the detailed test execution results.



##Notes: 

	­ Test cases include UI scenarios (shopping website, login, product selection, checkout) and API validation.
	­ All tests run in incognito mode with Chrome pop-ups disabled.
	­ ChromeDriver must be compatible with the local Chrome browser version.


