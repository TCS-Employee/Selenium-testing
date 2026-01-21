package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RediffHomePage {

    WebDriver driver;

    public RediffHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // "Create Account" link
    By createAccountLink = By.linkText("Create Account");

    public void clickCreateAccount() {
        driver.findElement(createAccountLink).click();
    }
}
