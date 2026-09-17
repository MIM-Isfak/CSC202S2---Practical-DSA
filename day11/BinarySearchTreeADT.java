class Node
{
	int data;
	Node left;
	Node right;
	
	Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinarySearchTreeADT
{
	Node root;
	
	public BinarySearchTreeADT()
	{
		this.root = null;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public Node insert(Node node, int data)
	{
		if (node == null)
		{
			node = new Node(data);
			return node;
		}

		if (data < node.data)
		{
			node.left = insert(node.left, data);
		}
		else if (data > node.data)
		{
			node.right = insert(node.right, data);
		}
		return node;
	}
	
	public void inorderTraversal(Node node)
	{
		if (node != null)
		{
			inorderTraversal(node.left);
			System.out.print(node.data+ " ");
			inorderTraversal(node.right);
		}
	}
	
	public void preorderTraversal(Node node)
	{
		if (node != null)
		{
			System.out.print(node.data+ " ");
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}
	}
	
	public void postorderTraversal(Node node)
	{
		if (node != null)
		{
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.print(node.data+ " ");
		}
	}
	
	public boolean search(Node node, int data)
	{
		if (node == null)
		{
			return false;
		}
		if (data == node.data)
		{
			return true;
		}
		if (data < node.data)
		{
			return search(node.left, data);
		}
		else
		{
			return search(node.right, data);
		}
	}
	
	public int findMin(Node node)
	{
		if (node == null)
		{
			System.out.println("Tree is empty");
		}
		while (node.left != null)
		{
			node = node.left;
		}
		return node.data;
	}
	
	public int findMax(Node node)
	{
		if (node == null)
		{
			System.out.println("Tree is empty");
		}
		while (node.right != null)
		{
			node = node.right;
		}
		return node.data;
	}
	
	public Node delete(Node node, int data)
	{
		if (node == null)
		{
			return null;
		}
		if (data < node.data)
		{
			node.left = delete(node.left, data);
		}
		else if (data > node.data)
		{
			node.right = delete(node.right, data);
		}
		else
		{
			// case 1: Node is leaf
			if (node.left == null && node.right == null)
			{
				node = null;
			}
			// case 2: Node has one child
			else if (node.left == null)
			{
				node = node.right;
			}
			else if (node.right == null)
			{
				node = node.left;
			}
			// case 3: Node has two child
			else
			{
				int findMin = findMin(node.right);
				node.data = findMin;
				node.right = delete(node.right, findMin);
			}
		}
		return node;
	}
	
	public static void main(String args[])
	{
		BinarySearchTreeADT bst = new BinarySearchTreeADT();
		
		bst.root = bst.insert(bst.root, 50);
		bst.root = bst.insert(bst.root, 30);
		bst.root = bst.insert(bst.root, 70);
		bst.root = bst.insert(bst.root, 20);
		bst.root = bst.insert(bst.root, 40);
		bst.root = bst.insert(bst.root, 60);
		bst.root = bst.insert(bst.root, 80);
		
		System.out.print("Inorder: ");
		bst.inorderTraversal(bst.root);
		System.out.println();
		
		System.out.print("Preorder: ");
		bst.preorderTraversal(bst.root);
		System.out.println();
		
		System.out.print("Postorder: ");
		bst.postorderTraversal(bst.root);
		System.out.println();
		
		System.out.println("Search 40: " + bst.search(bst.root, 40));
		System.out.println("Search 100: " + bst.search(bst.root, 100));
		
		System.out.println(bst.findMax(bst.root));
		System.out.println(bst.findMin(bst.root));
		
		bst.delete(bst.root,20);
		bst.inorderTraversal(bst.root);
		System.out.println();
		
	}
}