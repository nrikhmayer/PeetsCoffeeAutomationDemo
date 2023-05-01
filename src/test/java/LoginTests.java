import framework.Logger;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test(groups = {"Smoke", "Regression", "Login"})
    public void validUserLogin() {
        Logger.info("Verify positive login");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLogInButtonPresent(), "Login should be present");

        homePage.clickLogInButton().fillLogInForm(settings.getValidTestUser());
        assertTrue(homePage.isUsernamePresent(), "Logged in user name should be present");
    }
}