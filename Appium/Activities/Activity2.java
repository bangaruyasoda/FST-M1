package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 
{
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException
	{
		
		//set the desired capabilities or options
		UiAutomator2Options options= new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
	
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		
		
		options.noReset();
		
		//Initialize the object
		
		URL serverUrl = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverUrl,options);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
		
	@Test
    public void chromeTest() {
        // Find heading on the page
        String pageHeading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='Training Support']"
        )).getText();
 
        // Print to console
        System.out.println("Heading: " + pageHeading);
 
        // Find and click the About Us link
        driver.findElement(AppiumBy.accessibilityId("About Us")).click();
 
        // Find heading of new page and print to console
        String aboutPageHeading = driver.findElement(AppiumBy.xpath(
                "//android.widget.TextView[@text='About Us']"
        )).getText();
        System.out.println(aboutPageHeading);
    }
 

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
}
