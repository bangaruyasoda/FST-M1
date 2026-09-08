package googlechrome;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;

public class Activity2 
{

    private AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");
        options.withBrowserName("Chrome");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void validLoginTest() {

        driver.get("https://training-support.net/webelements");

        // Open Login Form page
        driver.findElement(
                By.xpath("//h2[contains(text(),'Login Form')]"))
                .click();

        // Enter valid credentials
        driver.findElement(By.id("username"))
                .sendKeys("admin");

        driver.findElement(By.id("password"))
                .sendKeys("password");

        // Click Submit/Login button
        driver.findElement(
                By.xpath("//button[contains(text(),'Login')]"))
                .click();

        // Capture result message
        String actualMessage = driver.findElement(
                By.id("action-confirmation"))
                .getText();

        // Assertion
        Assert.assertEquals(
                actualMessage,
                "Welcome Back, admin",
                "Valid login failed");
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        driver.navigate().refresh();

        // Enter invalid credentials
        driver.findElement(By.id("username"))
                .sendKeys("admin");

        driver.findElement(By.id("password"))
                .sendKeys("admin");

        // Click Submit/Login button
        driver.findElement(
                By.xpath("//button[contains(text(),'Login')]"))
                .click();

        // Capture result message
        String actualMessage = driver.findElement(
                By.id("action-confirmation"))
                .getText();

        // Assertion
        Assert.assertEquals(
                actualMessage,
                "Invalid Credentials",
                "Invalid login validation failed");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}