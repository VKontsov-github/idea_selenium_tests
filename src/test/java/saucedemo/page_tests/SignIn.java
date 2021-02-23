package saucedemo.page_tests;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import saucedemo.SaucedemoDriverSetUp;
import saucedemo.page_objects.InventoryPage;


/**
 * Created by VKontsov on 23.02.2021
 */

public class SignIn extends SaucedemoDriverSetUp {
    public InventoryPage inventoryPage;

    @Test
    public void failedSignIn() {
        signInPage.setUsername("standart");
        signInPage.setPassword("secret_sauce");
        signInPage.clickLoginButton();

        Assert.assertEquals(signInPage.getFailedLoginErrorText(),"Epic sadface: Username and password do not match any user in this service.");//failed assertion
    }

    @Test
    public void signIn() {
        signInPage.setUsername("standard_user");
        signInPage.setPassword("secret_sauce");
        signInPage.clickLoginButton();
        inventoryPage = new InventoryPage(driver);
        wait.until(ExpectedConditions.visibilityOf(inventoryPage.getLastItemCapture()));

        Assert.assertTrue("Loaded page is not an inventory page with products list",inventoryPage.isCorrectPageOpened());
    }
}
