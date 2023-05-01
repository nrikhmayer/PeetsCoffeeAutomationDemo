package pages;

import framework.Logger;
import framework.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Sign In']")
    WebElement signInButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillLogInForm(User user) {
        Logger.info("Enter name: " + user.name);
        email.sendKeys(user.name);

        Logger.info("Enter password: " + user.password);
        password.sendKeys(user.password);

        Logger.info("Click Sign In button");
        signInButton.submit();
    }
}