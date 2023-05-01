import framework.Settings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    Settings settings;

    @BeforeMethod(alwaysRun = true)
    void SetUp() {

        settings = new Settings();
        driver = settings.getDriver();

        driver.get(settings.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    void TearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(".//target//screenshots//" + result.getName() + System.currentTimeMillis() + ".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        driver.quit();
    }
}