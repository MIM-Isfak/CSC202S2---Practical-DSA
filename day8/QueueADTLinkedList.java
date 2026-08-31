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

public class QueueADTLinkedList
{
	Node front;
	Node rear;
	
	public QueueADTLinkedList()
	{
		front = null;
		rear = null;
	}
	
	public boolean isEmpty()
	{
		return front == null;
	}
	
	public void display()
	{
		if (isEmpty())
		{
			System.out.println("Queue is empty!");
			return;
		}
		System.out.print("Queue: ");
		Node temp = front;
		while (temp != null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void enqueue(int data)
	{
		Node newNode = new Node(data);
		if (isEmpty())
		{
			front = newNode;
			rear = newNode;
		}
		else
		{
			rear.next = newNode;
			rear = newNode;
		}
	}
	
	public int dequeue()
	{
		if (isEmpty())
		{
			System.out.println("Can't dequeue!");
			return -1;
		}
		
		int current = front.data;
		front = front.next;
		
		if (front == null)
		{
			rear = null;
		}
		return current;
	}
	
	public static void main(String args[])
	{
		QueueADTLinkedList qu = new QueueADTLinkedList();
		
		qu.enqueue(10);
		qu.enqueue(20);
		qu.enqueue(30);
		qu.display(); 
		
		System.out.println("Dequeued: " + qu.dequeue());
		qu.display();
	}
}
