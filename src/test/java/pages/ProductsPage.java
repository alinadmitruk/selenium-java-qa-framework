package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
//    WebDriver driver;
//    WebDriverWait wait;
    private By cartIcon = By.className("shopping_cart_link");
    public ProductsPage(WebDriver driver){
        super(driver);
    }

    private By items = By.className("inventory_item");
    public List<WebElement> getItems(){
        return driver.findElements(items);

    }
    private By productsTitle = By.className("title");
    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }
    private By addToCart = By.cssSelector("button.btn_inventory");
    public void addItemToCart(){
        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button.btn_inventory")
                )
        );
        button.click();
    }
    private By cartBadge = By.className("shopping_cart_badge");
    public String getCartCount(){
        List<WebElement> badges = driver.findElements(cartBadge);
            return badges.isEmpty() ? "0" : badges.get(0).getText();
    }

    public CartPage goToCart(){
        driver.findElement(cartIcon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_item")));
        return new CartPage(driver);
    }
    }

