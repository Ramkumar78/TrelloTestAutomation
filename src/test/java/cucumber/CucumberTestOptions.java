package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.BaseTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
		glue = {"cucumber.stepdefs"},
		features = {"src/test/java/cucumber/features"})


public class CucumberTestOptions {

	@BeforeClass
	public static void setUp(){
		try {
			BaseTests.launchApplication("chrome");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDown(){
		BaseTests.closeBrowser();
	}
}
