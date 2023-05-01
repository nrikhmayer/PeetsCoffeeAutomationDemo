package pages;

import framework.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShopPage extends BasePage {

    @FindBy(xpath = "//div[@class='product-list']/article")
    List<WebElement> items;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dismissAdsPopUpIfPresent();
    }

    public int getItemsCount() {
        Logger.info("Get items count");
        return items.size();
    }

    public ProductPage clickOnItemNumber(int number) {
        Logger.info("Click on item number: " + number);
        dismissAdsPopUpIfPresent();
        ScrollToElement(items.get(number));
        dismissAdsPopUpIfPresent();
        items.get(number).click();
        return new ProductPage(driver);
    }
}