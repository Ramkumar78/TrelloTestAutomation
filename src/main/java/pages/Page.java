package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Page {

    protected WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    By signInButton = By.xpath("/html/body/header/nav/div[2]/a[1]");
    By userIdEmail = By.id("user");
    By password = By.id("password");
    By loginButton = By.id("login");


    public Page goTo(String postUrl) {
        webDriver.get(postUrl);
        return new Page(webDriver);
    }


}
