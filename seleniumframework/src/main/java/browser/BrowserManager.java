package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserManager {

    public static WebDriver getDriver() {
        return new ChromeDriver();
    }
}