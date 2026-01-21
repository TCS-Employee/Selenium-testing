package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import browser.BrowserManager;
import pages.RediffHomePage;
import utils.ConfigReader;

public class RediffCreateAccountTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = BrowserManager.getDriver();
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
    }

    @Test
    public void verifyCreateAccountPageTitle() throws InterruptedException {

        RediffHomePage homePage = new RediffHomePage(driver);
        homePage.clickCreateAccount();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Create Rediffmail Account";

        Assert.assertEquals(actualTitle, expectedTitle,
                "Title does NOT match!");

        // ⏳ Stay on page for 2 seconds
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
