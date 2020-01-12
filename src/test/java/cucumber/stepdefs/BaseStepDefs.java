package cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.Page;
import utils.BaseTests;
//import widgets.SearchResults;

public class BaseStepDefs {

	protected String productName;
	protected String category;
	protected Page currentPage;
//	protected SearchResults searchResults;

	public BaseStepDefs() {
		currentPage = new Page(BaseTests.getWebDriver());
	}


	@Given("^User Navigates to Trello Login page$")
	public void userNavigatesToTrelloLoginPage() {

//		driver.get("https://trello.com");
	}



	@And("^Enters <username> and <password>$")
	public void entersUsernameAndPassword() {
	}
}
