package cucumber.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Page;
import util.BaseTests;

import java.util.concurrent.TimeUnit;


public class BaseStepDefs {

    private WebDriver driver;

    protected Page currentPage;
    //	protected SearchResults searchResults;
    private static String loginId = "kanniloli@gmail.com";
    private static String loginPasswd = "Test@123";

    public BaseStepDefs() {
        currentPage = new Page(BaseTests.getWebDriver());
    }


    @Given("^User Navigates to Trello Login page$")
    public void userNavigatesToTrelloLoginPage() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://trello.com");
        Assert.assertEquals("Trello", driver.getTitle());
    }


    @And("^Enters username and password")
    public void entersUsernameAndPassword() {
        driver.findElement(By.id("user")).sendKeys(loginId);
        driver.findElement(By.id("password")).sendKeys(loginPasswd);
        driver.findElement(By.id("login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^user is Logged in successfully$")
    public void userIsLoggedInSuccessfully() {
        Assert.assertTrue(driver.getPageSource().contains("successfull"));
    }

    @And("^creates the boadrd$")
    public void createsTheBoadrd() {
        driver.findElement(By.cssSelector("p > span")).click();
        driver.findElement(By.cssSelector(".subtle-input")).click();
        driver.findElement(By.cssSelector(".subtle-input")).sendKeys("test1");
        driver.findElement(By.cssSelector(".button > span:nth-child(2)")).click();
    }

    @Then("^the board is created successfully$")
    public void theBoardIsCreatedSuccessfully() {

        driver.findElement(By.cssSelector(".MEu8ZECLGMLeab")).click();
        driver.findElement(By.name("search-boards")).click();
        driver.findElement(By.name("search-boards")).sendKeys("test");
        Assert.assertEquals("test1", driver.getTitle());

    }
}
