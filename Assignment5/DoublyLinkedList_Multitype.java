class Node<T>
{
	T data;
	Node<T> next;
	Node<T> prev;

	public Node(T data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedListADT<T>
{
	Node<T> head;

	public DoublyLinkedListADT()
	{
		this.head = null;
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
		}
		else
		{
			newNode.next = head;
			head = newNode;
			head.next.prev = newNode;
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
			while(current != null)
			{
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}

	void displayReverse()
	{
		if(isEmpty())
		{
			System.out.println("Linked list is empty");
		}
		else
		{
			Node<T> current = head;
			while(current.next != null) // move to the last node first
			{
				current = current.next;
			}
			while(current != null)
			{
				System.out.print(current.data + " ");
				current = current.prev;
			}
			System.out.println();
		}
	}

	void insertAtEnd(T data)
	{
		Node<T> newNode = new Node<>(data);
		if(isEmpty())
		{
			head = newNode;
		}
		else
		{
			Node<T> current = head;
			while(current.next != null)
			{
				current = current.next;
			}
			current.next = newNode;
			newNode.prev = current;
		}
	}

	int getSize()
	{
		int count = 0;
		Node<T> current = head;
		while (current != null)
		{
			count++;
			current = current.next;
		}
		return count;
	}

	void insertAtPosition(T data , int index)
	{
		if(index<1 || index>getSize()+1)
		{
			System.out.println("Invalid index!");
			return;
		}
		if (index == 1)
		{
			insertAtFront(data);
			return;
		}

		Node<T> newNode = new Node<>(data);
		Node<T> current = head;
		for(int i=1; i <index-1; i++)
		{
			current = current.next;
		}
		newNode.next = current.next;
		newNode.prev = current;
		if(current.next != null)
		{
			current.next.prev = newNode;
		}
		current.next = newNode;
	}

	void deleteAtFront() // break the connection(connection means ".next" and ".prev")
	{
		if(isEmpty())
		{
			System.out.println("link list is empty!");
		}
		else
		{
			head = head.next;
			if(head != null)
			{
				head.prev = null;
			}
		}
	}

	void deleteAtEnd()
	{
		if(isEmpty())
		{
			System.out.println("linked list is empty!");
		}
		else if(head.next == null)
		{
			head = null;
		}
		else
		{
			Node<T> current = head;
			while(current.next.next != null)
			{
				current = current.next;
			}
			current.next = null;
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

		Node<T> current = head;
		for(int i = 1; i < index - 1; i++)
		{
			current = current.next;
		}
		current.next = current.next.next;
		if(current.next != null)
		{
			current.next.prev = current;
		}
	}

	int search(T key)
	{
		Node<T> current = head;
		int position = 1;

		while(current != null)
		{
			if(current.data.equals(key))
			{
				return position;
			}
			current = current.next;
			position++;
		}
		return -1;
	}
}