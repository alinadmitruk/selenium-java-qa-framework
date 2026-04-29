package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage  extends BasePage {
//    WebDriver driver;
//    WebDriverWait wait;
    public CartPage (WebDriver driver){
        super(driver);
    }
    private By cartItems = By.className("cart_item");
    private By itemName = By.className("inventory_item_name");
    private By removeButton = By.id("remove-sauce-labs-backpack");

    public void  removeItem(){
        driver.findElement(removeButton).click();
    }

    public int getItemsCount(){
        return driver.findElements(cartItems).size();
    }

    public String getFirstItemName(){
        return  driver.findElement(itemName).getText();
    }
    public boolean isCartNotEmpty(){
        return !driver.findElements(cartItems).isEmpty();
    }
}
