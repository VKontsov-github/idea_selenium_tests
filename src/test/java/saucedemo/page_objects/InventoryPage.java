package saucedemo.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by VKontsov on 23.02.2021
 */

public class InventoryPage {
    @FindBy(css = "#item_3_img_link .inventory_item_img")
    WebElement lastItemCapture;

    @FindBy(css = ".product_label")
    WebElement bodyTitle;

    @FindBy(css = "[class=\"fa-layers-counter shopping_cart_badge\"]")
    WebElement marketBasketCounter;

    //Constructor
    private WebDriver driver;
    private WebDriverWait wait;

    public InventoryPage (WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(this.driver, 10);

        PageFactory.initElements(driver, this);
    }

    public boolean isPageFullyLoad(){
        try {
            return lastItemCapture.isDisplayed();
        }   catch(NoSuchElementException ex){
            return false;
        }

    }

    public WebElement getLastItemCapture(){
        return lastItemCapture;
    }
    public WebElement getMarketBasketCounter() { return marketBasketCounter; }

    public boolean isCorrectPageOpened() {
        return bodyTitle.getText().toString().equals("Products");
    }

    public WebElement addToCartBtn() {
        WebElement one = lastItemCapture.findElement(By.xpath("../../.."));
        WebElement two = one.findElement(By.cssSelector("button"));
        return two;
    }

    public boolean isWebElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        }   catch (NoSuchElementException ex){
            return false;
        }
    }

    public void waitUntilPageIsFullyLoad() {
        wait.until(ExpectedConditions.visibilityOf(getLastItemCapture()));
    }
}
