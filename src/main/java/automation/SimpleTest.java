package automation;

import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void firstTest() {

        Browser.openBrowser();

        String url = ConfigReader.get("url");
        Browser.driver.get(url);

        System.out.println("Browser = " + ConfigReader.get("browser"));
        System.out.println("URL = " + url);

        Browser.closeBrowser();
    }
}
