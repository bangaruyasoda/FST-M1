package ProjectActivity;

    import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.annotations.Test;
	import java.util.List;

	public class Activity9 extends Fixtures
	{

	    @Test
	    public void printLeadNameAndUser() {

	        // Login
	        driver.findElement(By.id("user_name"))
	                .sendKeys("admin");

	        driver.findElement(By.id("username_password"))
	                .sendKeys("pa$$w0rd");

	        driver.findElement(By.id("bigbutton"))
	                .click();

	        // Navigate to Sales -> Leads
	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.linkText("Sales")))
	                .click();

	        wait.until(ExpectedConditions.elementToBeClickable(
	                By.linkText("Leads")))
	                .click();

	        // Wait for table to load
	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//table[contains(@class,'list')]")));

	        // Get all lead rows
	        List<WebElement> rows = driver.findElements(
	                By.xpath("//table[contains(@class,'list')]//tr[contains(@class,'oddListRowS1') or contains(@class,'evenListRowS1')]"));

	        System.out.println("Name\t\t\tUser");
	        System.out.println("------------------------------------------------");

	        int limit = Math.min(10, rows.size());

	        for (int i = 0; i < limit; i++) {

	            List<WebElement> cells =
	                    rows.get(i).findElements(By.tagName("td"));

	            // Update indexes if columns differ in your environment
	            String leadName = cells.get(2).getText();  // Name column
	            String userName = cells.get(7).getText();  // User column

	            System.out.println(leadName + "\t\t" + userName);
	        }
	    }

	}

