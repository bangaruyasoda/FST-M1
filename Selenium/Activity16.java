    package Activity;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Activity16 
	{
	    public static void main(String[] args) 
	    {
	    	WebDriver driver = new FirefoxDriver();
	        driver.get("https://training-support.net/webelements/selects");
	        System.out.println("Page title is: " + driver.getTitle());
	        WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
	        Select singleSelect = new Select(dropdown);
	        singleSelect.selectByVisibleText("Two");
	        // Print the selected option
	        System.out.println("Second option: " + singleSelect.getFirstSelectedOption().getText());

	        // Select the third option using index
	        singleSelect.selectByIndex(3);
	        // Print the selected option
	        System.out.println("Third option: " + singleSelect.getFirstSelectedOption().getText());

	        // Select the fourth option using value attribute
	        singleSelect.selectByValue("four");
	        // Print the selected option
	        System.out.println("Fourth option: " + singleSelect.getFirstSelectedOption().getText());

	        // Print all the options
	        List<WebElement> allOptions = singleSelect.getOptions();
	        System.out.println("Options in the dropdown: ");
	        for(WebElement option : allOptions) {
	            System.out.println(option.getText());
	        }
	        driver.quit();
	    }
	}
