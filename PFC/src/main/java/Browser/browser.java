package Browser;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browser {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void openUrl(String url) {
        driver.get(url);
    }

    public static void closeBrowser() {
        driver.quit();
    }
}