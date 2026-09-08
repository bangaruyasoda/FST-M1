package nativeapplication;

import java.time.Duration;
import java.util.Arrays;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import io.appium.java_client.AppiumDriver;

public class ActionBase 
{
	//Initialize the pointer
	private final PointerInput finger = new PointerInput(Kind.TOUCH,"finger");
	
	//Function to emulate swipe(drag/flick)
	public void doSwipe(AppiumDriver driver,int duration,Point start, Point end)
	{
		//Create the sequence of actions
		Sequence swipe = new Sequence(finger,1);
		//swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),Origin.viewport(), end));
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())); // 0 = Left click
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(duration), Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); // 0 = Left click
 
		// Perform the swipe
		driver.perform(Arrays.asList(swipe));
		
	}
	
	public void doTap(AppiumDriver driver,int duration,Point start)
	{
		//Create the sequence of actions
		Sequence tap = new Sequence(finger,1);
		//swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),Origin.viewport(), end));
		tap.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		tap.addAction(finger.createPointerDown(MouseButton.LEFT.asArg())); // 0 = Left click
		tap.addAction(new Pause(finger,Duration.ofMillis(100)));
		tap.addAction(finger.createPointerUp(MouseButton.LEFT.asArg())); // 0 = Left click
 
		// Perform the swipe
		driver.perform(Arrays.asList(tap));
		
	}

}
