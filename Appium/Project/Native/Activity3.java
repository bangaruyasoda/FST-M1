package nativeapplication;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3
{

    private AppiumDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setDeviceName("Android Emulator");

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyCompletedTasksToggle() {

        // Mark first task as complete
        driver.findElement(
                By.xpath("(//android.widget.CheckBox)[1]"))
                .click();

        // Mark second task as complete
        driver.findElement(
                By.xpath("(//android.widget.CheckBox)[2]"))
                .click();

        // Toggle completed tasks visibility
        driver.findElement(
                By.id("show_completed"))
                .click();

        // Verify only the third task is visible
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[@text='Complete Activity 3']"))
                        .isDisplayed(),
                "Activity 3 should be visible");

        // Verify completed tasks are hidden
        List<?> activity1 = driver.findElements(
                By.xpath("//*[@text='Complete Activity 1']"));

        List<?> activity2 = driver.findElements(
                By.xpath("//*[@text='Complete Activity 2']"));

        Assert.assertEquals(activity1.size(), 0,
                "Activity 1 should be hidden");

        Assert.assertEquals(activity2.size(), 0,
                "Activity 2 should be hidden");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}