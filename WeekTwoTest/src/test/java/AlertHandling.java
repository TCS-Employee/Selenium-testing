import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertHandling {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.findElement(By.name("login"));
        System.out.println("Email field located successfully");

        driver.findElement(By.name("passwd"));
        System.out.println("Password field located successfully");

        driver.findElement(By.name("proceed")).click();

        Alert alert1 = driver.switchTo().alert();

        String actualAlertText1 = alert1.getText();
        System.out.println("Login Alert Text: " + actualAlertText1);
        
//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        alert1.accept();   // close alert

        String expectedAlertText1 = "Please enter a valid user name";

        if (actualAlertText1.equals(expectedAlertText1)) {
            System.out.println("Login Alert validation PASSED");
        } else {
            System.out.println("Login Alert validation FAILED");
            System.out.println("Expected: " + expectedAlertText1);
            System.out.println("Actual: " + actualAlertText1);
        }


        driver.findElement(By.partialLinkText("Forgot")).click();

        driver.findElement(By.name("next")).click();

        Alert alert2 = driver.switchTo().alert();

        String actualAlertText2 = alert2.getText();
        System.out.println("Forgot Password Alert Text: " + actualAlertText2);
        
//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        alert2.accept();

        String expectedAlertText2 = "Please enter your email ID";

        if (actualAlertText2.equals(expectedAlertText2)) {
            System.out.println("Forgot Password Alert validation PASSED");
        } else {
            System.out.println("Forgot Password Alert validation FAILED");
            System.out.println("Expected: " + expectedAlertText2);
            System.out.println("Actual: " + actualAlertText2);
        }
        
//        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.quit();
    }
}
