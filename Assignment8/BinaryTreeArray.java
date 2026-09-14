public class BinaryTreeArray
{
	String treeArray[];
	int maxSize;
	int currentSize;
	
	public BinaryTreeArray(int maxSize)
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
		
		inorderTraversal(2 * index + 1);
		System.out.print(treeArray[index] + " ");
		inorderTraversal(2 * index + 2);
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
	
	// Get children of a node
	public void getChildren(String data)
	{
		int index = searchElement(data);
		if(index == -1)
		{
			System.out.println(data + " not found");
			return;
		}
		int li = 2 * index + 1;
		int ri = 2 * index + 2;
		String lc = (li < currentSize && treeArray[li] != null) ? treeArray[li] : "-";
		String rc = (ri < currentSize && treeArray[ri] != null) ? treeArray[ri] : "-";
		System.out.println("Children of '" + data + "': left = " + lc + ", right = " + rc);
	}
	
	// Get parent of a node
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
	
	// Set right child of a node
	public void setRightChild(String parentData, String newData)
	{
		int index = searchElement(parentData);
		if(index == -1)
		{
			System.out.println(parentData + " not found");
			return;
		}
		int ri = 2 * index + 2;
		treeArray[ri] = newData;
		System.out.println("Set right child of '" + parentData + "' to '" + newData + "'");
	}
	
	// Set parent value of a node
	public void setParentValue(String childData, String newData)
	{
		int index = searchElement(childData);
		if(index <= 0)
		{
			System.out.println("No parent to set");
			return;
		}
		int parentIndex = (index - 1) / 2;
		treeArray[parentIndex] = newData;
		System.out.println("Set parent of '" + childData + "' to '" + newData + "'");
	}
	
	// Height of tree
	public int height(int index)
	{
		if(index >= currentSize || treeArray[index] == null || treeArray[index].equals("-"))
		{
			return -1;
		}
		int lh = height(2 * index + 1);
		int rh = height(2 * index + 2);
		return 1 + Math.max(lh, rh);
	}
	
	// Size of tree
	public int size()
	{
		int count = 0;
		for(int i = 0; i < currentSize; i++)
		{
			if(treeArray[i] != null && !treeArray[i].equals("-"))
			{
				count++;
			}
		}
		return count;
	}
	
	
	
	public static void main(String args[])
	{
		BinaryTreeArray tr = new BinaryTreeArray(15);
		
		tr.insertElement("b");   // index 0
		tr.insertElement("i");   // index 1
		tr.insertElement("n");   // index 2
		tr.insertElement("-");   // index 3
		tr.insertElement("a");   // index 4
		tr.insertElement("r");   // index 5
		tr.insertElement("-");   // index 6
		tr.insertElement("-");   // index 7
		tr.insertElement("-");   // index 8
		tr.insertElement("-");   // index 9
		tr.insertElement("y");   // index 10
		
		System.out.println("\n(Level order)");
		tr.levelOrderTraversal();
		
		System.out.println("\n(Inorder)");
		tr.inorderTraversal(0);
		System.out.println();
		
		System.out.println("\n(Q1)");
		tr.getChildren("y");
		
		System.out.println("\n(Q2)");
		tr.getParent("r");
		
		System.out.println("\n(Q3)");
		tr.setRightChild("n", "o");
		tr.levelOrderTraversal();
		
		System.out.println("\n(Q4)");
		tr.setParentValue("y", "g");
		tr.levelOrderTraversal();
		
		System.out.println("\n(Q5)");
		System.out.println("Height = " + tr.height(0));
		
		System.out.println("\n(Q6)");
		System.out.println("Size = " + tr.size());
	}
}