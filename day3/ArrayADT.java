public class ArrayADT
{
	private int[] array;
	private int size;
	
	public ArrayADT(int capacity)
	{
		array = new int[capacity];
		size = 0;
	}
	
	void insertElement(int index, int element)
	{
		if(index<0 || index>array.length-1)
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
	
	void display()
	{
		for(int i = 0; i < size; i++)
        {
            System.out.print(array[i] + " ");
        }
	}
	
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
	
	void getElement(int index)
	{
		if(index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException("Index is not in range!");
		}

		System.out.println(array[index]);
	}
	
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
	
	void getSize()
	{
		System.out.println(size);
	}
	
	int search(int element)
	{
		for(int i=0; i<size-1; i++)
		{
			if(element == array[i])
			{
				System.out.println("Index of the searched element: "+array[i]);
			}
			
		}
		return -1;
	}
	
	
	
	public static void main(String args[])
	{
		ArrayADT arr = new ArrayADT(5);
		arr.insertElement(0,10);
		arr.insertElement(1,20);
		arr.insertElement(2,30);
		
		// arr.display();
		
		// arr.deleteInPosition(0);
		// arr.display();
		
		// arr.getElement(1);
		// arr.updateElement(2,50);
		// arr.display();
		// arr.getSize();
		arr.search(50);
	}
}