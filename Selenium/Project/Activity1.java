	package ProjectActivity;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity1 extends Fixtures
{
	
	@Test
	public void pageTitleTest()
	{
		Assert.assertEquals(driver.getTitle(),"SuiteCRM");
	}
	

}
