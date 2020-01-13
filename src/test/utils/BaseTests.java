package utils;

import com.google.common.io.Files;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import pages.Page;
import utils.Environments;

import java.awt.font.OpenType;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private static WebDriver webDriver;
    protected static Page homePage;

    @Parameters({"browser"})
    @BeforeClass
    public static void launchApplication(String browser) throws Exception {


        if (webDriver == null) {
            DesiredCapabilities cap = null;
            if(browser.equalsIgnoreCase("firefox"))
            {
                cap = DesiredCapabilities.firefox();
                cap.setBrowserName("firefox");
                //cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
            }
            if(browser.equalsIgnoreCase("internet explorer"))
            {
                cap = DesiredCapabilities.internetExplorer();
                cap.setBrowserName("internet explorer");
                cap.setPlatform(org.openqa.selenium.Platform.ANY);
            }
            if(browser.equalsIgnoreCase("chrome"))
            {
                setDriverProperty();
                cap = DesiredCapabilities.chrome();
                cap.setBrowserName("chrome");
                cap.setPlatform(org.openqa.selenium.Platform.ANY);
            }
            webDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    @AfterClass
    public static void closeBrowser() {
        webDriver.quit();
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) webDriver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            Files.move(screenshot, new File("resources/screenshot/failedTest.png"));
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setDriverProperty() {
        if (System.getProperty("os.name").contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        }
    }


}
