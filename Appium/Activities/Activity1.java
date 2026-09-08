package activities;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class Activity1 

{
	AppiumDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException
	{
		//File object for the application
		File testApp = new File("src/test/resources/Calculator.apk");
		//set the desired capabilities or options
		UiAutomator2Options options= new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		options.setAppPackage("com.android.home");
		options.setAppActivity("com.google.android.apps.Chrome.Main");
		
		
		options.noReset();
		
		//Initialize the object
		
		URL serverUrl = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverUrl,options);		
	}
	
	 @BeforeMethod
	public void clearResults()
	{
		driver.findElement(AppiumBy.accessibilityId("clear")).click();
	}
	
	
	@Test
	public void additionTest()
	{
		driver.findElement(AppiumBy.id("digit_7")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("digit_3")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		String result = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
		assertEquals(result,"10");
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}


}
