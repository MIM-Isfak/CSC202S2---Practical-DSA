class Node
{
	int data;
	Node int next;
	
	public Node(int data)
	{
		this.data = data;
		this.next = next;
	}
	
}

public class QueueADTLinkedList
{
	Node int front;
	Node int rear;
	

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
		if(isEmpty())
		{
			Syatem.out.println("Queue is epty!");
			return;
		}
		System.out.print("Queue: ");
		
	}
	
	public void enqueue()
	{
		if(isEmpty())
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
		if(isEmpty())
		{
			Syetem.out.println("Can't dequeue!")
		}
		int current = front.data;
		front = front.next
		
		if(front == null)
		{
			rear == null;
		}
		return current;
	}
	
	public static void main(String args[])
	{
		QueueADTLinkedList qu = new QueueADTLinkedList();
	}
	
}