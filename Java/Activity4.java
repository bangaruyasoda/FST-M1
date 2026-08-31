package Activity;
import java.util.Arrays;

public class Activity4 
{
   static void ascendingSort(int array[]) 
	  {
	      for (int i = 1; i < array.length; i++) 
	        {
	            int key = array[i];
	            int j = i - 1;
	              while (j >= 0 && key < array[j]) 
	              {
	                array[j + 1] = array[j];
	                j--;
	               }
	             array[j + 1] = key;
	        }
	    }
	    
	    public static void main(String args[])
	    {
	        int[] data = { 9, 5, 1, 4, 3 };
	        // Pass the unsorted array to the sorting function
	        ascendingSort(data);
	        // Print sorted array
	        System.out.println("Sorted Array in Ascending Order: ");
	        System.out.println(Arrays.toString(data));
	    }
	}
	