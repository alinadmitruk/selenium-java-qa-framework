package pages;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends BasePage {
//    WebDriver driver;
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

//    private By productsTitle = By.className("title");
//    public String getProductsTitle(){
//        return driver.findElement(productsTitle).getText();
//    }
//    private By errorMessege = By.cssSelector("[data-test='error']");
//    public String getErrorMessege(){
//        return driver.findElement(errorMessege).getText();
//    }
//    private By items = By.className("inventory_item_price");
//    public List<WebElement> getItems(){
//        return driver.findElements(items);
//
//    }
    }}
