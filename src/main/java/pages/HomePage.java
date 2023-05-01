package pages;

import framework.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(css = ".header__logo")
    WebElement logo;

    @FindBy(xpath = "//div[contains(@class, 'desktop-only')]//span[text()='Log in']")
    WebElement logInButton;

    @FindBy(css = ".desktop-only .header-utils__login-text")
    WebElement userName;

    @FindBy(xpath = "//a[@data-id='shop-nav']")
    WebElement shopButton;

    @FindBy(id = "cartButton")
    WebElement shoppingCartButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dismissAdsPopUpIfPresent();
    }

    public boolean isLogoPresent() {
        return isElementPresent(logo);
    }

    public boolean isLogInButtonPresent() {
        return isElementPresent(logInButton);
    }

    public boolean isUsernamePresent() {
        return isElementPresent(userName) && !userName.getText().isEmpty();
    }

    public LogInPage clickLogInButton() {
        Logger.info("Click log in button");
        logInButton.click();
        return new LogInPage(driver);
    }

    public ShopPage clickShopButton() {
        Logger.info("Click shop button");
        shopButton.click();
        return new ShopPage(driver);
    }

    public ShoppingCartPage clickShoppingCart() {
        Logger.info("Click shopping cart button");
        shoppingCartButton.click();
        return new ShoppingCartPage(driver);
    }
}