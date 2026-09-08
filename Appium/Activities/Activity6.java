package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 
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
//			
//		@Test
//		public void homePageTest()
//		{
//			driver.get("https://training-support.net");
//			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).click();
//			String aboutHeading = driver.findElement(AppiumBy.xpath("//android.widget.TextView[1]")).getText();
//			assertEquals(aboutHeading , "About Us");
//		}

		@DataProvider(name = "coordinates")
		public Object[][] inputValues() {
		//// Calculate the phone screen dimensions
		//Dimension dims = driver.manage().window().getSize();
		//
		//// Calculate the start and end points
		//Point start = new Point(
		//(int) (Float.valueOf(startX)  * dims.getWidth()), 
		//(int) (Float.valueOf(startY) * dims.getHeight())
		//);
		//Point end = new Point(
		//(int) (Float.valueOf(endX) * dims.getWidth()), 
		//(int) (Float.valueOf(endY) * dims.getHeight())
		//);

		// Create the start and end points
		Point start = new Point(540, 1920);
		Point end_25 = new Point(356, 1920);
		Point end_75 = new Point(734, 1920);

		return new Object[][] {
		{start, end_25, "25%"},
		{start, end_75, "75%"},
		};
	}	 
		public void homePageTest()
		{
			//Open the page
			driver.get("https://training-support.net/webelements/sliders");
		
		}

		
		@Test(dataProvider = "coordinates")
		public void testVolumeSlider(Point start, Point end,String expectedVolume)
		{
			
			// Wait for page to load
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar[@resource-id='volume']")));
			//Drag the slider
			
			new ActionBase().doSwipe(driver, 2000, start, end);
	 
			// Assertions
			String volumeText= driver.findElement(AppiumBy.xpath("//android.widget.TextView[contains(@text,'%')]")).getText();
			assertEquals(volumeText,expectedVolume);
		}
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}
	}



