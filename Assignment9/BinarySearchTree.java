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

public class BinarySearchTree 
{

    Node root = null;

    Node insert(Node node, int key) 
	{
        if (node == null) 
		{
            return new Node(key);
        }
        if (key < node.data) 
		{
            node.left = insert(node.left, key);
        } 
		else if (key > node.data) 
		{
            node.right = insert(node.right, key);
        }
        return node;
    }

    void inorder(Node node) 
	{
        if (node != null) 
		{
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    void preorder(Node node) 
	{
        if (node != null) 
		{
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    void postorder(Node node) 
	{
        if (node != null) 
		{
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    boolean search(Node node, int key)
	{
        if (node == null) 
		{
            return false;
        }
        if (key == node.data) 
		{
         	return true;
        } 
		else if (key < node.data) 
		{
            return search(node.left, key);
        } 
		else 
		{
            return search(node.right, key);
        }
    }

    int findMin(Node node) 
	{
        while (node.left != null) 
		{
            node = node.left;
        }
        return node.data;
    }

    int findMax(Node node) 
	{
        while (node.right != null) 
		{
            node = node.right;
        }
        return node.data;
    }

    Node delete(Node node, int key)
	{
        if (node == null) 
		{
            return null;
        }
        if (key < node.data) 
		{
            node.left = delete(node.left, key);
        }
		else if (key > node.data) 
		{
            node.right = delete(node.right, key);
        }
		else 
		{
 
            if (node.left == null) 
			{
                return node.right;
            }
            if (node.right == null) 
			{
                return node.left;
            }
            node.data = findMin(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    public static void main(String[] args) 
	{
        BinarySearchTree tree = new BinarySearchTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int i = 0; i < values.length; i++)
		{
            tree.root = tree.insert(tree.root, values[i]);
        }

        System.out.print("Inorder   : ");
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Preorder  : ");
        tree.preorder(tree.root);
        System.out.println();

        System.out.print("Postorder : ");
        tree.postorder(tree.root);
        System.out.println();

        System.out.println("Search 40 : " + tree.search(tree.root, 40));
        System.out.println("Search 90 : " + tree.search(tree.root, 90));

        System.out.println("Minimum   : " + tree.findMin(tree.root));
        System.out.println("Maximum   : " + tree.findMax(tree.root));

        tree.root = tree.delete(tree.root, 80);
        tree.root = tree.delete(tree.root, 70);
        tree.root = tree.delete(tree.root, 30);

        System.out.print("After delete (Inorder) : ");
        tree.inorder(tree.root);
        System.out.println();
    }
}