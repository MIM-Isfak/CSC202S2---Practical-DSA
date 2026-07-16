public class ArrayOperationQ2
{
	static int countThefrequency(ArrayADT arr, int target)
	{
		int count = 0;
		int size = arr.getSize();
		
		for(int i = 0; i < size; i++)
		{
			if(arr.getElement(i)==target)
			{
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args)
	{
		ArrayADT arr = new ArrayADT(6);
		arr.insertElement(0, 5);
		arr.insertElement(1, 3);
		arr.insertElement(2, 5);
		arr.insertElement(3, 7);
		arr.insertElement(4, 5);
		arr.insertElement(5, 2);

		System.out.println("countThefrequency of 5: " + countThefrequency(arr, 5));
	}
}