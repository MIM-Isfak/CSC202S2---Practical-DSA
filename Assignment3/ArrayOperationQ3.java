public class ArrayOperationQ3
{
	static void removeDuplicates(ArrayADT arr)
	{
		int i = 0;
		while(i < arr.getSize())
		{
			int j = 0;
			boolean isDuplicate = false;

			while(j < i)
			{
				if(arr.getElement(i) == arr.getElement(j))
				{
					isDuplicate = true;
					break;
				}
				j++;
			}

			if(isDuplicate)
			{
				arr.deleteInPosition(i);
			}
			else
			{
				i++;
			}
		}
	}

	public static void main(String[] args)
	{
		ArrayADT arr = new ArrayADT(6);
		arr.insertElement(0, 5);
		arr.insertElement(1, 3);
		arr.insertElement(2, 5);
		arr.insertElement(3, 7);
		arr.insertElement(4, 3);
		arr.insertElement(5, 7);

		System.out.println("Before removing duplicates:");
		arr.display();

		removeDuplicates(arr);

		System.out.println("\nAfter removing duplicates:");
		arr.display();
	}
}