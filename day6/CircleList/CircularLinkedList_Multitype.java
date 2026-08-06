class Node<T>
{
	T data;
	Node<T> next;
	
	public Node(T data)
	{
		this.data = data;
		this.next = null;
	}
}

class CircularLinkedListADT<T>
{
	Node<T> head;
	Node<T> tail;
	
	public CircularLinkedListADT()
	{
		this.head = null;
		this.tail = null;
	}
	
	boolean isEmpty()
	{
		return head == null;
	}
	
	void insertAtFront(T data)
	{
		Node<T> newNode = new Node<>(data);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
			tail.next = head;
		}
		else
		{
			newNode.next = head;
			head = newNode;
			tail.next = head;
		}
	}
	
	void insertAtEnd(T data)
	{
		Node<T> newNode = new Node<>(data);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
			tail.next = head;
		}
		else
		{
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
	}
	
	void display()
	{
		if(isEmpty())
		{
			System.out.println("Linked list is empty");
		}
		else
		{
			Node<T> current = head;
			do
			{
				System.out.print(current.data + " ");
				current = current.next;
			}
			while(current != head);
			System.out.println();
		}
	}
	
	int getSize()
	{
		if(isEmpty())
		{
			return 0;
		}
		int count = 0;
		Node<T> current = head;
		do
		{
			count++;
			current = current.next;
		}
		while(current != head);
		return count;
	}
	
	void insertAtPosition(T data, int index)
	{
		if(index < 1 || index > getSize() + 1)
		{
			System.out.println("invalid index!");
			return;
		}
		if(index == 1)
		{
			insertAtFront(data);
			return;
		}
		if(index == getSize() + 1)
		{
			insertAtEnd(data);
			return;
		}
		
		Node<T> newNode = new Node<>(data);
		Node<T> current = head;
		for(int i = 1; i < index - 1; i++)
		{
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
	}
	
	void deleteAtFront()
	{
		if(isEmpty())
		{
			System.out.println("linked list is empty!");
		}
		else if(head == tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			head = head.next;
			tail.next = head;
		}
	}
	
	void deleteAtEnd()
	{
		if(isEmpty())
		{
			System.out.println("linked list is empty!");
		}
		else if(head == tail)
		{
			head = null;
			tail = null;
		}
		else
		{
			Node<T> current = head;
			while(current.next != tail)
			{
				current = current.next;
			}
			current.next = head;
			tail = current;
		}
	}
	
	void deleteAtPosition(int index)
	{
		if(index < 1 || index > getSize())
		{
			System.out.println("invalid index!");
			return;
		}
		if(index == 1)
		{
			deleteAtFront();
			return;
		}
		if(index == getSize())
		{
			deleteAtEnd();
			return;
		}
		
		Node<T> current = head;
		for(int i = 1; i < index - 1; i++)
		{
			current = current.next;
		}
		current.next = current.next.next;
	}
	
	int search(T key)
	{
		if(isEmpty())
		{
			return -1;
		}
		Node<T> current = head;
		int position = 1;
		do
		{
			if(current.data.equals(key))
			{
				return position;
			}
			current = current.next;
			position++;
		}
		while(current != head);
		return -1;
	}
}

public class CircularLinkedList_Multitype
{
	public static void main(String args[])
	{
		// Integer type
		CircularLinkedListADT<Integer> intList = new CircularLinkedListADT<>();
		intList.insertAtFront(10);
		intList.insertAtFront(20);
		intList.insertAtFront(30);
		intList.display();
		
		// String type
		CircularLinkedListADT<String> strList = new CircularLinkedListADT<>();
		strList.insertAtFront("Java");
		strList.insertAtEnd("Python");
		strList.insertAtEnd("Rust");
		strList.display();
		
		System.out.println("Search Python: " + strList.search("Python"));
	}
}