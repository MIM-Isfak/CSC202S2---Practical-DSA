public class BinaryTreeArrayQuestion
{
	String treeArray[];
	int maxSize;
	int currentSize;
	
	public BinaryTreeArrayQuestion(int maxSize)
	{
		this.maxSize = maxSize;
		this.treeArray = new String[maxSize];   
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
	
	public void insertElement(String data)
	{
		if(isFull())
		{
			System.out.println("Tree overflow");
		}
		else
		{
			treeArray[currentSize++] = data;
			System.out.println("Inserted " + data);
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
				System.out.print(treeArray[i] + " ");
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
		
		inorderTraversal(2 * index + 1);              // left
		System.out.print(treeArray[index] + " ");     // root
		inorderTraversal(2 * index + 2);              // right
	}
	
	public int searchElement(String data)             
	{
		for(int i = 0; i < currentSize; i++)          
		{
			if(treeArray[i].equals(data))
			{
				return i;
			}
				
		}
		return -1;
	}
	
	public void deleteElement(String data)
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
		treeArray[currentSize - 1] = null;             
		currentSize--;
		
		System.out.println("Deleted " + data);
	}
	
	
	public void getParent(String data)
	{
		int index = searchElement(data);
		if(index <= 0)
		{
			System.out.println("No parent (root or not found)");
			return;
		}
		int parentIndex = (index - 1) / 2;
		System.out.println("Parent of '" + data + "' = " + treeArray[parentIndex]);
	}
	
	public void getChildren(String data)
	{
		int index = searchElement(data);
		if(index == -1)
		{
			System.out.println(data + " not found");
			return;
		}
		int li = 2 * index + 1, ri = 2 * index + 2;
		String lc = (li < currentSize) ? treeArray[li] : "-";
		String rc = (ri < currentSize) ? treeArray[ri] : "-";
		System.out.println("Children of '" + data + "': left = " + lc + ", right = " + rc);
	}
	
	public static void main(String args[])
	{
		BinaryTreeArrayQuestion tr = new BinaryTreeArrayQuestion(20);
		tr.insertElement("b"); //index 0
		tr.insertElement("i"); //index 1
		tr.insertElement("n"); //index 2
		tr.insertElement("-"); //index 3
		tr.insertElement("a"); //index 4
		tr.insertElement("r"); //index 5
		tr.insertElement("-"); //index 6
		tr.insertElement("-"); //index 7
		tr.insertElement("-"); //index 8
		tr.insertElement("-"); //index 9
		tr.insertElement("y"); //index 10
		
		tr.levelOrderTraversal();
		tr.getChildren("y");
		tr.getParent("r");
	}
}