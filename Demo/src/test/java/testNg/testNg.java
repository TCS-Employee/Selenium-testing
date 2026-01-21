package testNg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Browser.browser;
import Page.page1;
import Page.page2;

public class testNg extends browser {

    @BeforeClass
    public void setup() throws Exception {
        openBrowser();
        navigate("Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");
    }

    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String actualTitle = page1.title();
        AssertJUnit.assertEquals(actualTitle.contains("Rediff"),
                "Home page title does not match");
    }

    @Test(priority = 2)
    public void clickCreateAccount() {
        page1.click("Create Account");
    }

    @Test(priority = 3)
    public void enterUserDetails() {
        page2.fullName("Test User");
        page2.mailId("venkitesh1980");
        page2.checkAvailability();
    }

    @Test(priority = 4)
    public void verifyAvailabilityMessage() {
        String msg = page2.message();
        AssertJUnit.assertNotNull(msg, "Availability message is not displayed");
    }

	@AfterMethod
	@AfterClass
    public void tearDown() {
        closeBrowser();
    }
}