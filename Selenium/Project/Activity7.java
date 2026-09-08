package ProjectActivity;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.annotations.Test;
	import java.util.regex.Matcher;
	import java.util.regex.Pattern;


public class Activity7 extends Fixtures
{
	    @Test
	    public void readLeadPhoneNumber() {

	        // Login
	        driver.findElement(By.id("user_name"))
	                .sendKeys("admin");

	        driver.findElement(By.id("username_password"))
	                .sendKeys("pa$$w0rd");

	        driver.findElement(By.id("bigbutton"))
	                .click();

	        // Navigate to Sales -> Leads
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//a[contains(text(),'Sales')]")))
	                .click();

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//a[contains(text(),'Leads')]")))
	                .click();

	        // Click Additional Information icon from first lead row
	        WebElement infoIcon = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                        By.xpath("(//img[contains(@src,'info') or contains(@alt,'View')])[1]")));

	        infoIcon.click();

	        // Read popup
	        WebElement popup = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.className("ui-dialog-content")));

	        String popupText = popup.getText();

	        System.out.println("Popup Details:");
	        System.out.println(popupText);

	        // Extract phone number
	        Pattern pattern = Pattern.compile("\\+?[0-9()\\-\\s]{7,20}");
	        Matcher matcher = pattern.matcher(popupText);

	        if (matcher.find()) {
	            System.out.println("Phone Number: " + matcher.group());
	        } else {
	            System.out.println("Phone Number not found");
	        }
	    }

	}

