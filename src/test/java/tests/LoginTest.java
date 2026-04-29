package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.List;


public class LoginTest extends BaseTest {

    @Test
    public void validLoginPage() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        String title = productsPage.getProductsTitle();
        Assertions.assertEquals("Products", title);
        System.out.println("Test login executed");

    }


    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_sauce");
        String error = loginPage.getErrorMessage();
        Assertions.assertTrue(error.contains("Username and password do not match"));
        System.out.println("Test invalid login executed");
    }



}

