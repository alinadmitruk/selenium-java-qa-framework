package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartTest  extends BaseTest {
    @Test
    public void addToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCart();
        CartPage cartPage = productsPage.goToCart();
        Assertions.assertEquals(1, cartPage.getItemsCount());
    }
    @Test
    public void cartIsNotEmptyTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCart();
        CartPage cartPage = productsPage.goToCart();
        Assertions.assertTrue(cartPage.isCartNotEmpty());
    }
    @Test
    public void removeFromCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addItemToCart();
        CartPage cartPage = productsPage.goToCart();
        Assertions.assertEquals(1, cartPage.getItemsCount());
        cartPage.removeItem();
        Assertions.assertEquals(0, cartPage.getItemsCount());
    }
}


