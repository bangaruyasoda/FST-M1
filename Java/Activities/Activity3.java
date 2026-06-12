package Activity;

public class Activity3 
{
	String device;
	int value;
	String status;
	public String adjustDevice(String device, int value)
	{
     switch(device)
	  {
	   case "THERMOSTAT" :
		if(value>=40) 
		{ 
			status="[Thermostat] Warning: Temperature high";
		}	
		else
		if(value<40)
		{
			status = "[Thermostat] Temperature is set to value = "+ value;	
		}
		break;
	case "LIGHT" : status= "[Light] Adjusting brightness to <value>%";
	    break;
	default : status="Explicitly handle null case as well.";
	    break;
	   }
	return status;
     }
 }