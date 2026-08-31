package Activity;
import java.util.*;

public class Activity13 
 {
	public void registerUser(String ageInput) 
	  {
		 try 
			 {
			   int age = Integer.parseInt(ageInput);
     			if (age < 18) 
     			{
					throw new IllegalArgumentException("Users must be at least 18 years old to register.");
				}
				
				System.out.println("Registration successful! Welcome aboard.");

			  } 
		 catch (NumberFormatException e) 
		    {
				System.out.println("Registration Failed -> Error: Age must be a valid number.");
			} 
		 catch (IllegalArgumentException e)
		    {
				System.out.println("Registration Failed -> Error: " + e.getMessage());
			}
		}

		public static void main(String[] args) 
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your age: ");
			String age = scan.nextLine();
			scan.close();
			new Activity13().registerUser(age);
		}
	}

