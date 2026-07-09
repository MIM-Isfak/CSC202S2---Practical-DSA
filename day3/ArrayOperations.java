public class ArrayOperations
{
    // 1. Minimum value
    static int findMinimum(ArrayADT arr)
    {
        int size = arr.getSize();
        int min = arr.getElement(0);

        for(int i = 1; i < size; i++)
        {
            int current = arr.getElement(i);
            if(current < min)
            {
                min = current;
            }
        }
        return min;
    }

    // 2. Reverse the array
    static void reverseArray(ArrayADT arr)
    {
        int left = 0;
		int right = arr.getSize() - 1;

        while(left < right)
        {
            int leftVal = arr.getElement(left);
            int rightVal = arr.getElement(right);

            arr.updateElement(left, rightVal);
            arr.updateElement(right, leftVal);

            left++;
            right--;
        }
    }

    // 3. Frequency count
    static void countFrequency(ArrayADT arr)
    {
        int size = arr.getSize();
        boolean[] counted = new boolean[size];

        // for(int i = 0; i < size; i++)
        // {
            // if(counted[i]) 	
			// {
				// continue;	// idhu already count aagirichu, skip pannu
			// }

            // int value = arr.getElement(i);
            // int count = 1;

            // for(int j = i + 1; j < size; j++)
            // {
                // if(arr.getElement(j) == value)
                // {
                    // count++;
                    // counted[j] = true;
                // }
            // }
            // System.out.println(value + " -> " + count + " times");
        // }
		for(int i = 0; i < size; i++)
        {
            if(!counted[i]) 	
			{
				int value = arr.getElement(i);
				int count = 1;

				for(int j = i + 1; j < size; j++)
				{
					if(arr.getElement(j) == value)
					{
						count++;
						counted[j] = true;
					}
				}
				System.out.println(value + " -> " + count + " times");
			}

            
        }
    }

    // 4. Merge two sorted arrays
    static ArrayADT mergeSortedArrays(ArrayADT arr1, ArrayADT arr2)
    {
        int size1 = arr1.getSize();
        int size2 = arr2.getSize();
        ArrayADT merged = new ArrayADT(size1 + size2);

        int i = 0, j = 0, insertPos = 0;

        // Rendu arrays-um sorted-a irukkanum nu assume pannitu, oru sorted merge pannunga
        while(i < size1 && j < size2)
        {
            int val1 = arr1.getElement(i);
            int val2 = arr2.getElement(j);

            if(val1 <= val2)
            {
                merged.insertElement(insertPos, val1);
                i++;
            }
            else
            {
                merged.insertElement(insertPos, val2);
                j++;
            }
            insertPos++;
        }

        // Left-over elements irundha, atha add pannu
        while(i < size1)
        {
            merged.insertElement(insertPos, arr1.getElement(i));
            i++; insertPos++;
        }
        while(j < size2)
        {
            merged.insertElement(insertPos, arr2.getElement(j));
            j++; insertPos++;
        }

        return merged;
    }

    // 5. Bubble sort
    static void bubbleSort(ArrayADT arr)
    {
        int size = arr.getSize();

        for(int i = 0; i < size - 1; i++)
        {
            boolean swapped = false;

            for(int j = 0; j < size - 1 - i; j++)
            {
                int current = arr.getElement(j);
                int next = arr.getElement(j + 1);

                if(current > next)
                {
                    arr.updateElement(j, next);
                    arr.updateElement(j + 1, current);
                    swapped = true;
                }
            }
            if(!swapped) 
			{
				break;
			}
        }
    }

    // 6. Selection sort
    static void selectionSort(ArrayADT arr)
    {
        int size = arr.getSize();

        for(int i = 0; i < size - 1; i++)
        {
            int minIndex = i;

            for(int j = i + 1; j < size; j++)
            {
                if(arr.getElement(j) < arr.getElement(minIndex))
                {
                    minIndex = j;
                }
            }

            if(minIndex != i)
            {
                int temp = arr.getElement(i);
                arr.updateElement(i, arr.getElement(minIndex));
                arr.updateElement(minIndex, temp);
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayADT arr = new ArrayADT(5);
        arr.insertElement(0, 30);
        arr.insertElement(1, 10);
        arr.insertElement(2, 50);
        arr.insertElement(3, 20);
        arr.insertElement(4, 10);

        System.out.println("Minimum: " + findMinimum(arr));

        System.out.print("Before reverse: "); arr.display();
        reverseArray(arr);
        System.out.print("\nAfter reverse: "); arr.display();

        System.out.println("\nFrequency count:");
        countFrequency(arr);

        System.out.print("Before bubble sort: "); arr.display();
        bubbleSort(arr);
        System.out.print("\nAfter bubble sort: "); arr.display();

        // Merge example
        ArrayADT a = new ArrayADT(3);
        a.insertElement(0, 1); a.insertElement(1, 3); a.insertElement(2, 5);

        ArrayADT b = new ArrayADT(3);
        b.insertElement(0, 2); b.insertElement(1, 4); b.insertElement(2, 6);

        ArrayADT merged = mergeSortedArrays(a, b);
        System.out.print("\nMerged sorted array: "); merged.display();
    }
}