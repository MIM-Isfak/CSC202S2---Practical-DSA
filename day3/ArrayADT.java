public class ArrayADT
{
	private int[] array;
	private int size;
	
	public ArrayADT(int capacity)
	{
		array = new int[capacity];
		size = 0;
	}
	
	//Array la middle-la oru element insert pannanum(Shift-right logic)
	void insertElement(int index, int element)
	{
		if(index<0 || index>size)
		{
			throw new IndexOutOfBoundsException("Index is not in range!");
		}
		else if(size==array.length)
		{
			System.out.println("Array is full!");
		}
		else
		{
			for(int i=size-1; i>=index; i--)
			{
				array[i+1]=array[i];
			}
			array[index]=element;
			size++;
		}		
	}
	
	//Array a view panrathu
	void display()
	{
		for(int i = 0; i < size; i++)
        {
            System.out.print(array[i] + " ");
        }
	}
	
	//Array size a check panrathu
	int getSize()
	{
		return size;
	}
	
	//Array la specific infex la delete panrathu(Shift-left logic)
	void deleteInPosition(int index)
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Index is not in range!");
		}
		else if(size==0)
		{
			System.out.println("Array is emppty!");
		}
		else
		{
			//Shift elements to the left to remove element at the given index
			for(int i = index; i < size - 1; i++)
			{
				array[i] = array[i + 1];
			}
			array[size - 1] = 0;
			size--;
		}
	}
	
	//Array la specific index la elemnt a edukkurathu
	int getElement(int index)
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Index is not in range!");
		}

		return array[index];
	}
	
	//Array la specific index la element a update panrathu
	void updateElement(int index, int newElement)
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Index is not in range!");
		}
		else
		{
			array[index] = newElement;
		}
	}
	
	//Array la element irukka ndu search panrathu
	int search(int element)
	{
		for(int i = 0; i < size; i++)
		{
			if(element == array[i])
			{
				System.out.println("Index of the searched element: " + i);
				return i;
			}
		}
		System.out.println("Element not found in the array!");
		return -1;
	}
}
