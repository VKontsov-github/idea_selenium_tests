package saucedemo.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by VKontsov on 23.02.2021
 */

public class SignInPage {
    @FindBy(id="user-name")
    WebElement usernameInput;

    @FindBy(id="password")
    WebElement passwordInput;

    @FindBy(id="login-button")
    WebElement login_button;

    @FindBy(css = "h3")
    WebElement failedLoginTextBlock;

    //Constructor
    private WebDriver driver;
    private static String PAGE_URL="https://www.saucedemo.com/";

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);

        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        login_button.click();
    }

    public String getFailedLoginErrorText() {
        return failedLoginTextBlock.getText();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }
}