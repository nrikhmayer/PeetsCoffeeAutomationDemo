import framework.Logger;
import framework.utils.Utils;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.ShopPage;
import pages.ShoppingCartPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartTests extends BaseTest {

    @Test(groups = {"Regression", "ShoppingCart"})
    public void addRemoveProduct() {
        Logger.info("Verify adding product to the shopping card");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLogoPresent(), "Logo should be present");

        ShopPage shopPage = homePage.clickShopButton();
        ProductPage productPage = shopPage.clickOnItemNumber(Utils.getRandomInteger(shopPage.getItemsCount()));
        ShoppingCartPage cartPage = productPage.clickAddToCardButton();

        Logger.info("Verify shopping card is not empty");
        assertEquals(cartPage.getFirstItemQuantity(), 1, "Shopping item quantity mismatch");

        Logger.info("Verify removing product from the shopping card");
        cartPage.removeFirstItem();

        Logger.info("Verify shopping card is empty");
        assertTrue(cartPage.isCartEmpty(), "Shopping cart was not empty");
    }
}