package pages;

import framework.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

    @FindBy(id = "btnAddToBagText")
    WebElement addToCardButton;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage clickAddToCardButton() {
        Logger.info("Click add to card button");
        addToCardButton.click();
        return new ShoppingCartPage(driver);
    }
}