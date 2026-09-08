package nativeapplication;


	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.*;

	import java.net.URL;
	import java.time.Duration;

	public class Activity2 
	{
	    private AppiumDriver driver;
	    private final String categoryName = "Training";

	    @BeforeClass
	    public void setup() throws Exception {

	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("Android");
	        options.setDeviceName("Android Emulator");
	        options.setApp(System.getProperty("user.dir") + "/apps/ToDo.apk");

	        driver = new AndroidDriver(
	                new URL("http://127.0.0.1:4723"),
	                options);

	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    }

	    @Test
	    public void addCategoryAndAssignTask() {

	        // Open menu
	        driver.findElement(By.xpath("//android.widget.ImageButton"))
	                .click();

	        // Edit Categories
	        driver.findElement(By.xpath("//*[@text='Edit categories']"))
	                .click();

	        // Create new category
	        driver.findElement(By.xpath("//*[@text='New']"))
	                .click();

	        driver.findElement(By.id("android:id/edit"))
	                .sendKeys(categoryName);

	        driver.findElement(By.xpath("//*[@text='OK']"))
	                .click();

	        // Save categories
	        driver.findElement(By.xpath("//*[@text='OK']"))
	                .click();

	        // Long press second task
	        WebElement secondTask = driver.findElement(
	                By.xpath("(//*[@resource-id='android:id/text1'])[2]"));

	        TouchAction<?> action = new TouchAction<>(driver);
	        action.longPress(PointOption.point(
	                secondTask.getLocation().getX(),
	                secondTask.getLocation().getY()))
	                .release()
	                .perform();

	        // Edit task
	        driver.findElement(By.xpath("//*[@text='Edit']"))
	                .click();

	        // Select category
	        driver.findElement(By.id("com.example.todo:id/category"))
	                .click();

	        driver.findElement(
	                By.xpath("//*[@text='" + categoryName + "']"))
	                .click();

	        // Save task
	        driver.findElement(By.xpath("//*[@text='OK']"))
	                .click();

	        // Filter by category
	        driver.findElement(By.id("com.example.todo:id/filter"))
	                .click();

	        driver.findElement(
	                By.xpath("//*[@text='" + categoryName + "']"))
	                .click();

	        // Verify second task appears in selected category
	        Assert.assertTrue(
	                driver.findElement(
	                        By.xpath("//*[@text='Complete Activity 2']"))
	                        .isDisplayed(),
	                "Task is not assigned to selected category");
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

