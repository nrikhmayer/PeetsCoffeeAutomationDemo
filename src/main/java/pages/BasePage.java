package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    @FindBy(id = "dismissbutton2header1")
    WebElement dismissPopUpButton;

    protected WebDriver driver;

    public boolean isElementPresent(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void ScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public <T extends BasePage> T openPage(Class<T> className) {
        return PageFactory.initElements(driver, className);
    }

    // Note:  in a real production test, we need to set up specific cookie values for a popup disappear
    // for tests where we don't verify this pop-up
    public void dismissAdsPopUpIfPresent(){
        if (isElementPresent(dismissPopUpButton)) {
            dismissPopUpButton.click();
        }
    }
}