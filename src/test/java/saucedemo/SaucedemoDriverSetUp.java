package saucedemo;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import saucedemo.page_objects.SignInPage;

/**
 * Created by VKontsov on 23.02.2021
 */

public class SaucedemoDriverSetUp {
    public WebDriver driver;
    public WebDriverWait wait;
    public SignInPage signInPage;
//    public InventoryPage inventoryPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver-88_0_4324_96.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        signInPage = new SignInPage(driver);
    }

    @After
    public void close() {
        driver.quit();
    }
}