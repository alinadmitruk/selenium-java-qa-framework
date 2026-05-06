package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;



public class LoginTest extends BaseTest {

    @Test
    public void validLoginPage() throws Exception {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(props.getProperty("username"), props.getProperty("password"));
        String title = productsPage.getProductsTitle();
        Assertions.assertEquals("Products", title);

    }


    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong_user", "wrong_sauce");
        String error = loginPage.getErrorMessage();
        Assertions.assertTrue(error.contains("Username and password do not match"));
    }
    @Test
    public void lockedOutUserTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");
        String error = loginPage.getErrorMessage();
        Assertions.assertTrue(error.contains("Sorry, this user has been locked out"));
    }


}

