import java.util.*;

public class SearchNumber
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("How many Numbers: ");
		int num = sc.nextInt();
		int arr[] = new int[num];
		
		System.out.println("Enter " + num + " numbers:");
        for(int i = 0; i < num; i++)
        {
            arr[i] = sc.nextInt();
        }
		
		System.out.print("\nOriginal Array: ");
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]);
            if(i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println();
		
		System.out.print("Enter Number to search: ");
		int target = sc.nextInt();
		
		int index = linearSearch(arr,target);
		if(index != -1)
			System.out.println("Found " + target + " at index " + index);
		else
			System.out.println(target + " not found!");
		
		bubbleSort(arr);
		
		
	}
	//search
	static int linearSearch(int arr[], int target)
    {
        int index = -1;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == target)
			{
				return i;
			}
		}
		return -1;
    }
	
	//sort
	static void bubbleSort(int arr[])
	{
		 for(int i = 0; i < arr.length-1; i++)
        {
            for(int j = 0; j < arr.length-i-1; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j]   = arr[j+1];
                    arr[j+1] = temp;
                }
            }
		}
		System.out.print("\nSorted Array: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]);
			if(i < arr.length - 1)
				System.out.print(", ");
		}
		System.out.println();
	}
}