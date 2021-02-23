package saucedemo.page_tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.SaucedemoDriverSetUp;
import saucedemo.page_objects.InventoryPage;
import saucedemo.page_objects.SignInPage;

/**
 * Created by VKontsov on 23.02.2021
 */

public class Inventory extends SaucedemoDriverSetUp {
    private InventoryPage inventoryPage;

    public void goToInventoryPageOfUser(String username, String password){
        signInPage = new SignInPage(driver);
        signInPage.login(username, password);
        inventoryPage = new InventoryPage(driver);
    }

    @Test
    public void marketBasketCounterWorksWell() {
        goToInventoryPageOfUser("standard_user", "secret_sauce");
        Assert.assertTrue("Loaded page is not an inventory page with products list",inventoryPage.isCorrectPageOpened());

        int n;
        int n1;

        if (inventoryPage.isWebElementPresent(inventoryPage.getMarketBasketCounter())){
            n = Integer.parseInt(inventoryPage.getMarketBasketCounter().getText()); //get current counter value
        } else {
            n = 0;
        }

        inventoryPage.addToCartBtn().click();
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.getMarketBasketCounter()));
        n1 = Integer.parseInt(inventoryPage.getMarketBasketCounter().getText()); //get counter value after button click

        Assert.assertTrue(" \"add to cart\" button don't works",n1>n); // counter should have raised after button click
    }
}