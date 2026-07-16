public class ArrayOperationQ5
{
	static void insertionSort(ArrayADT arr)
	{
		int size = arr.getSize();

		for(int i = 1; i < size; i++)
		{
			int key = arr.getElement(i);
			int j = i - 1;

			while(j >= 0 && arr.getElement(j) > key)
			{
				arr.updateElement(j + 1, arr.getElement(j));
				j--;
			}

			arr.updateElement(j + 1, key);
		}
	}

	public static void main(String[] args)
	{
		ArrayADT arr = new ArrayADT(6);
		arr.insertElement(0, 5);
		arr.insertElement(1, 2);
		arr.insertElement(2, 9);
		arr.insertElement(3, 1);
		arr.insertElement(4, 5);
		arr.insertElement(5, 6);

		System.out.println("Before sorting:");
		arr.display();

		insertionSort(arr);

		System.out.println("\nAfter sorting:");
		arr.display();
	}
}