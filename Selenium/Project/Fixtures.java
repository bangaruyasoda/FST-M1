package ProjectActivity;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Fixtures extends BaseClass
{	
	   @BeforeClass
	    public static void setUp() 
	    {
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.get("https://crm.alchemy.hguy.co");
	    }
	   
	   @AfterClass
	    public static void tearDown()
	    {
	        // Close the browser
	        driver.quit();
	    }
}
	

