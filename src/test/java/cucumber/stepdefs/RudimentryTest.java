package cucumber.stepdefs;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class RudimentryTest {
    private WebDriver driver;
    private static String loginId = "kanniloli@gmail.com";
    private static String loginPasswd = "Test@123";



    @Test
    public void sample2() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://trello.com");
        Assert.assertEquals("Trello",driver.getTitle());
        driver.findElement(By.xpath("/html/body/header/nav/div[2]/a[1]")).click();
        driver.findElement(By.id("user")).sendKeys(loginId);
        driver.findElement(By.id("password")).sendKeys(loginPasswd);
        driver.findElement(By.id("login")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains("successfull"));
        String loggedIn=driver.getTitle();
        if(loggedIn.equals("Log in to Trello")){
            System.out.println("user logged in successfully");
        };



    }

    public static void setChromeDriverProperty() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "//resources//chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        }
    }
}
