public class BinaryTreeADTArray
{
	int treeArray[];
	int maxSize;
	int currentSize;
	
	public BinaryTreeADTArray(int maxSize)
	{
		this.maxSize = maxSize;
		this.treeArray = new int[maxSize];
		this.currentSize = 0;
	}
	
	public boolean isEmpty()
	{
		return currentSize == 0;
	}
	
	public boolean isFull()
	{
		return currentSize == maxSize;
	}
	
	public void insertElement(int data)
	{
		if(isFull())
		{
			System.out.println("Tree overflow");
		}
		else
		{
			treeArray[currentSize++] = data;
			System.out.println("Inserted "+ data);
		}
	}
	
	public void levelOrderTraversal()
	{
		if(isEmpty())
		{
			System.out.println("Tree is empty.");
		}
		else
		{
			for(int i = 0; i < currentSize; i++)
			{
				if(treeArray[i]!=0)
				{
					System.out.print(treeArray[i] + " ");
				}
			}
			System.out.println();
		}
	}
	
	public void inorderTraversal(int index)
	{
		if(isEmpty())
		{
			System.out.println("tree underflow");
			return;
		}
		if(index < 0 || index >= currentSize)
		{
			return; 
		}
		
		inorderTraversal(2 * index + 1);          // left
		System.out.print(treeArray[index] + " "); // root
		inorderTraversal(2 * index + 2);          // right
	}
	
	public int searchElement(int data)
	{
		
		
		for(int i = 0; i < currentSize; i++)
		{
			if(treeArray[i] == data)
			{
				return i;
			}
		}
		return -1;
	}
	
	public void deleteElement(int data)
	{
		if(isEmpty())
		{
			System.out.println("Tree underflow. Cannot delete.");
			return;
		}
		
		int index = searchElement(data);
		
		if(index == -1)
		{
			System.out.println(data + " not found in the tree.");
			return;
		}
		treeArray[index] = treeArray[currentSize - 1];
		treeArray[currentSize - 1] = 0;
		currentSize--;
		
		System.out.println("Deleted " + data);
	}
	
	public static void main(String args[])
	{
		BinaryTreeADTArray tr = new BinaryTreeADTArray(10);
		tr.insertElement(5);
		tr.insertElement(3);
		tr.insertElement(9);
		tr.insertElement(2);
		tr.insertElement(4);
		tr.insertElement(7);
		tr.insertElement(1);
		
		tr.levelOrderTraversal();
		tr.inorderTraversal(0);
		System.out.println();
		System.out.println("Index of searched element = "+tr.searchElement(9));
		tr.deleteElement(4);
		tr.inorderTraversal(0);
	}
}
