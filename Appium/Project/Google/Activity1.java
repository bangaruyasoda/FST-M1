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
	import java.util.List;

	public class Activity1 
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
	    public void verifyTodoListFunctionality() {

	        driver.get("https://training-support.net/webelements");

	        // Open To-Do List card
	        driver.findElement(
	                By.xpath("//h2[contains(text(),'To-Do List')]"))
	                .click();

	        WebElement inputBox =
	                driver.findElement(By.cssSelector("input"));

	        // Add Task 1
	        inputBox.sendKeys("Add tasks to list");
	        driver.findElement(By.xpath("//button")).click();

	        // Add Task 2
	        inputBox.clear();
	        inputBox.sendKeys("Get number of tasks");
	        driver.findElement(By.xpath("//button")).click();

	        // Add Task 3
	        inputBox.clear();
	        inputBox.sendKeys("Clear the list");
	        driver.findElement(By.xpath("//button")).click();

	        // Strike out newly added tasks
	        driver.findElement(
	                By.xpath("//*[text()='Add tasks to list']"))
	                .click();

	        driver.findElement(
	                By.xpath("//*[text()='Get number of tasks']"))
	                .click();

	        driver.findElement(
	                By.xpath("//*[text()='Clear the list']"))
	                .click();

	        // Get all tasks in the list
	        List<WebElement> tasks =
	                driver.findElements(
	                        By.cssSelector("ul li"));

	        // 2 default tasks + 3 added tasks
	        Assert.assertEquals(
	                tasks.size(),
	                5,
	                "Incorrect number of tasks displayed");
	    }

	    @AfterClass
	    public void tearDown() {

	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

