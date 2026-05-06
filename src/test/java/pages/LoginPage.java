package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");


    public ProductsPage login(String username, String password){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }
    private By errorMessage = By.cssSelector("[data-test='error']");
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();

    }}
