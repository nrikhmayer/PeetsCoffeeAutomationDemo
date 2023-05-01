package pages;

import framework.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {

    @FindBy(css = ".bag-item__increment-number")
    WebElement itemQuantity;

    @FindBy(css = ".bag-item__remove")
    WebElement removeItem;

    @FindBy(css = ".bag__empty-heading")
    WebElement emptyCartText;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dismissAdsPopUpIfPresent();
    }

    public Integer getFirstItemQuantity() {
        Logger.info("Get quantity of first item");
        return Integer.parseInt(itemQuantity.getText());
    }

    public void removeFirstItem() {
        Logger.info("Click remove button for first item");
        removeItem.click();
    }

    public boolean isCartEmpty() {
        return isElementPresent(emptyCartText);
    }
}