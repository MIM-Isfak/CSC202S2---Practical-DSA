public class ArrayOperationQ1
{
	static int findSecondLargest(ArrayADT arr)
	{
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		int size = arr.getSize();

		for(int i = 0; i < size; i++)
		{
			int element = arr.getElement(i);

			if(element > largest)
			{
				secondLargest = largest; 
				largest = element;
			}
			else if(element > secondLargest && element != largest)
			{
				secondLargest = element;
			}
		}

		if(secondLargest == Integer.MIN_VALUE)
		{
			System.out.println("No Second largest element!");
		}

		return secondLargest;
	}

	public static void main(String[] args)
	{
		ArrayADT arr = new ArrayADT(5);
		arr.insertElement(0, 10);
		arr.insertElement(1, 25);
		arr.insertElement(2, 8);
		arr.insertElement(3, 25);
		arr.insertElement(4, 17);

		System.out.println("Second Largest: " + findSecondLargest(arr));
	}
}