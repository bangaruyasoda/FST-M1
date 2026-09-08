package googlechrome;

	import io.appium.java_client.AppiumDriver;
    import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
	import org.openqa.selenium.By;
	import org.testng.Assert;
	import org.testng.annotations.*;
	import java.net.URL;
	import java.time.Duration;


public class Activity3 
{
	private AppiumDriver driver;

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

	    @Test
	    public void verifyLoginPopup() {

	        // Open website
	        driver.get("https://training-support.net/webelements");

	        // Open Popups page
	        driver.findElement(
	                By.xpath("//h2[contains(text(),'Popups')]"))
	                .click();

	        // Open Login Popup
	        driver.findElement(
	                By.xpath("//button[contains(text(),'Open Popup')]"))
	                .click();

	        // Enter credentials
	        driver.findElement(By.id("username"))
	                .sendKeys("admin");

	        driver.findElement(By.id("password"))
	                .sendKeys("password");

	        // Submit login
	        driver.findElement(
	                By.xpath("//button[contains(text(),'Submit')]"))
	                .click();

	        // Capture success message
	        String actualMessage = driver.findElement(
	                By.id("action-confirmation"))
	                .getText();

	        // Assertion
	        Assert.assertEquals(
	                actualMessage,
	                "Welcome Back, admin",
	                "Login popup validation failed");
	    }

	    @AfterClass
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}