class Node
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

class CircularLinkedListADT
{
	Node head;
	Node tail;
	
	public CircularLinkedListADT()
	{
		this.head = null;
		this.tail = null;
	}
	
	boolean isEmpty()
	{
		return head == null;
	}
	
	void insertAtFront(int data)
	{
		Node newNode = new Node(data);
		if(isEmpty())
		{
			head = newNode;
			tail = newNode;
			tail.next = head;   // points to itself
		}
		else
		{
			newNode.next = head;
			head = newNode;
			tail.next = head;   // tail should always point back to new head
		}
	}
	
	void insertAtEnd(int data)
	{
		Node newNode = new Node(data);
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
			tail.next = head;   // circular link back to head
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
			Node current = head;
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
		Node current = head;
		do
		{
			count++;
			current = current.next;
		}
		while(current != head);
		return count;
	}
	
	void insertAtPosition(int data, int index)
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
		
		Node newNode = new Node(data);
		Node current = head;
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
		else if(head == tail)   // only one node
		{
			head = null;
			tail = null;
		}
		else
		{
			head = head.next;
			tail.next = head;   // re-link tail to new head
		}
	}
	
	void deleteAtEnd()
	{
		if(isEmpty())
		{
			System.out.println("linked list is empty!");
		}
		else if(head == tail)   // only one node
		{
			head = null;
			tail = null;
		}
		else
		{
			Node current = head;
			while(current.next != tail)
			{
				current = current.next;
			}
			current.next = head;   // close the circle
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
		
		Node current = head;
		for(int i = 1; i < index - 1; i++)
		{
			current = current.next;
		}
		current.next = current.next.next;
	}
	
	int search(int key)
	{
		if(isEmpty())
		{
			return -1;
		}
		Node current = head;
		int position = 1;
		do
		{
			if(current.data == key)
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

public class CircularLinkedList
{
	public static void main(String args[])
	{
		CircularLinkedListADT linkedList = new CircularLinkedListADT();
		
		System.out.println(linkedList.isEmpty());
		
		linkedList.insertAtFront(10);
		linkedList.insertAtFront(20);
		linkedList.insertAtFront(30);
		
		linkedList.display();
		
		System.out.println("1st element: " + linkedList.head.data);
		System.out.println("2nd element: " + linkedList.head.next.data);
		System.out.println("3rd element: " + linkedList.head.next.next.data);
		
		System.out.println("LinkedList Size: " + linkedList.getSize());
		
		linkedList.insertAtPosition(40, 4);
		linkedList.display();
		
		linkedList.insertAtPosition(50, 3);
		linkedList.display();
		
		linkedList.deleteAtEnd();
		linkedList.display();
		
		linkedList.deleteAtPosition(2);
		linkedList.display();
		
		System.out.println("Search 40: " + linkedList.search(40));
	}
}