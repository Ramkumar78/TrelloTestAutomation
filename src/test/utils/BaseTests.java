package utils;

import com.google.common.io.Files;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import pages.Page;
import utils.Environments;

import java.awt.font.OpenType;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class BaseTests {
    private static WebDriver webDriver;
    protected static Page homePage;


    @BeforeClass
    public static void launchApplication() {
        setChromeDriverProperty();
        webDriver = new ChromeDriver();
        webDriver.get(Environments.HOME);
        webDriver.manage().window().maximize();
        homePage = new Page(webDriver);
    }

    @AfterClass
    public static void closeBrowser() {
        webDriver.quit();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if(ITestResult.FAILURE==result.getStatus()){
            var camera=(TakesScreenshot)webDriver;
            File screenshot=camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot,new File("resources/screenshot/failedTest.png"));
        }
  }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setChromeDriverProperty() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        }
    }



}
