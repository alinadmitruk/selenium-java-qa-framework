package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class ProductTest extends BaseTest {
    @Test
    public void productTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");

        List<WebElement> itemsList = productsPage.getItems();
        int count = itemsList.size();
        Assertions.assertTrue(count > 0);
    }
}
