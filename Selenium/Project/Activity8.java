package ProjectActivity;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.testng.annotations.Test;
	import java.util.List;	
		public class Activity8 extends Fixtures {
	           
	            @Test
	            public void printFirstFiveOddRows() {

	                // Login
	                driver.findElement(By.id("user_name"))
	                        .sendKeys("admin");

	                driver.findElement(By.id("username_password"))
	                        .sendKeys("pa$$w0rd");

	                driver.findElement(By.id("bigbutton"))
	                        .click();

	                // Navigate to Sales -> Accounts
	                wait.until(ExpectedConditions.elementToBeClickable(
	                        By.linkText("Sales"))).click();

	                wait.until(ExpectedConditions.elementToBeClickable(
	                        By.linkText("Accounts"))).click();

	                // Wait for Accounts table
	                wait.until(ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//table[contains(@class,'list')]")));

	                // Get all account rows
	                List<WebElement> rows = driver.findElements(
	                        By.xpath("//table[contains(@class,'list')]//tr[contains(@class,'oddListRowS1') or contains(@class,'evenListRowS1')]"));

	                System.out.println("First 5 Odd Numbered Rows:");

	                int count = 0;

	                for (int i = 0; i < rows.size() && count < 5; i += 2) {

	                    // Account Name is usually in the 3rd column
	                    String accountName = rows.get(i)
	                            .findElement(By.xpath("./td[3]"))
	                            .getText();

	                    System.out.println("Row " + (i + 1) + ": " + accountName);

	                    count++;
	                }
	            }

}
