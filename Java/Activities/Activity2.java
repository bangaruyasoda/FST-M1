package Activity;

public class Activity2 {

	public static void main(String[] args)
	{
		int [] num =  {10, 77, 10, 54, -11, 10};
		int sum=0;
		for(int i=0;i<num.length;i++)
		{
			if(num[i]==10)
			{
				sum=sum+num[i];
			}
					
		}
		
		if(sum==30)
		{
			System.out.println("the sum is 30");
		}
		else
		{
			System.out.println("the sum not 30");	
		}

	}

}
