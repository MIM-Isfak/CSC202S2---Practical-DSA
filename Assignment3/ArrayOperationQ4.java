public class ArrayOperationQ4
{
	static boolean isEqual(ArrayADT arr1, ArrayADT arr2)
	{
		if(arr1.getSize() != arr2.getSize())
		{
			return false;
		}

		for(int i = 0; i < arr1.getSize(); i++)
		{
			if(arr1.getElement(i) != arr2.getElement(i))
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		ArrayADT arr1 = new ArrayADT(5);
		arr1.insertElement(0, 1);
		arr1.insertElement(1, 2);
		arr1.insertElement(2, 3);
		arr1.insertElement(3, 4);
		arr1.insertElement(4, 5);

		ArrayADT arr2 = new ArrayADT(5);
		arr2.insertElement(0, 1);
		arr2.insertElement(1, 2);
		arr2.insertElement(2, 3);
		arr2.insertElement(3, 4);
		arr2.insertElement(4, 5);

		ArrayADT arr3 = new ArrayADT(4);
		arr3.insertElement(0, 1);
		arr3.insertElement(1, 2);
		arr3.insertElement(2, 3);
		arr3.insertElement(3, 4);

		ArrayADT arr4 = new ArrayADT(5);
		arr4.insertElement(0, 1);
		arr4.insertElement(1, 2);
		arr4.insertElement(2, 9);
		arr4.insertElement(3, 4);
		arr4.insertElement(4, 5);

		System.out.println("arr1 vs arr2: " + isEqual(arr1, arr2));
		System.out.println("arr1 vs arr3: " + isEqual(arr1, arr3));
		System.out.println("arr1 vs arr4: " + isEqual(arr1, arr4));
	}
}