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
        signInPage.login("standart", "secret_sauce");
        Assert.assertEquals(signInPage.getFailedLoginErrorText(),"Epic sadface: Username and password do not match any user in this service.");//failed assertion
    }

    @Test
    public void signIn() {
        signInPage.login("standard_user", "secret_sauce");

        inventoryPage = new InventoryPage(driver);
        inventoryPage.waitUntilPageIsFullyLoad();

        Assert.assertTrue("Loaded page is not an inventory page with products list",inventoryPage.isCorrectPageOpened());
    }
}
