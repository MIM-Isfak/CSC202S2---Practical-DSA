// class Node
// {
	// int data;
	// Node next;
	// Node prev;
	
	// public Node(int data)
	// {
		// this.data = data;
		// this.next = null;
		// this.prev = null;
	// }
// }
// class DoublyLinkedListADT
// {
	// Node head;
	
	// public DoublyLinkedListADT()
	// {
		// this.head = null;
	// }
	
	// boolean isEmpty()
	// {
		// return head == null;
	// }
	
	// void insertAtFront(int data)
	// {
		// Node newNode = new Node(data);
		// if(isEmpty())
		// {
			// head = newNode;
		// }
		// else
		// {
			// newNode.next = head;
			// head = newNode;
			// head.next.prev = newNode;
			
		// }
	// }
	
	// void display()
	// {
		// if(isEmpty())
		// {
			// System.out.println("Linked list is empty");
		// }
		// else
		// {
			// Node current = head;
			// while(current != null)
			// {
				// System.out.print(current.data + " ");
				// current = current.next;
			// }
			// System.out.println();
		// }
	// }
	
	// void displayReverse()
	// {
		// if(isEmpty())
		// {
			// System.out.println("Linked list is empty");
		// }
		// else
		// {
			// Node current = head;
			// while(current.next != null) // move to the last node first
			// {
				// current = current.next;
			// }
			// while(current != null)
			// {
				// System.out.print(current.data + " ");
				// current = current.prev;
			// }
			// System.out.println();
		// }
	// }
	
	// void insertAtEnd(int data)
	// {
		// Node newNode = new Node(data);
		// if(isEmpty())
		// {
			// head = newNode;
		// }
		// else
		// {
			// Node current = head;
			// while(current.next != null)
			// {
				// current = current.next;
			// }
			// current.next = newNode;
			// newNode.prev = current;
		// }
	// }
	
	// int getSize()
	// {
		// int count = 0;
		// Node current = head;
		// while (current != null)
		// {
			// count++;
			// current = current.next;
		// }
		// return count;
	// }
	
	// void insertAtPosition(int data , int index)
	// {
		// if(index<1 || index>getSize()+1)
		// {
			// System.out.println("Invalid index!");
			// return;
		// }
		// if (index == 1)
		// {
			// insertAtFront(data);
			// return;
		// }
		
		// Node newNode = new Node (data);
		// Node current = head;
		// for(int i=1; i <index-1; i++)
		// {
			// current = current.next;
		// }
		// newNode.next = current.next;
		// newNode.prev = current;
		// System.out.println("ans: "+current.next);
		// System.out.println("ans: "+current.next.prev);
		// if(current.next != null)
		// {
			// current.next.prev = newNode;
		// }
		// current.next = newNode;
	// }
	
	// void deleteAtFront() // break the connection(connection means ".next" and ".prev")
	// {
		// if(isEmpty())
		// {
			// System.out.println("link list is empty!");
		// }
		// else
		// {
			// head = head.next;
			// if(head != null)
			// {
				// head.prev = null;
			// }
		// }
	// }
	
	// void deleteAtEnd()
	// {
		// if(isEmpty())
		// {
			// System.out.println("linked list is empty!");
		// }
		// else if(head.next == null)
		// {
			// head = null;
		// }
		// else
		// {
			// Node current = head;
			// while(current.next.next != null)
			// {
				// current = current.next;
			// }
			// current.next = null;
		// }
	// }
	// void deleteAtPosition(int index)
	// {
		// if(index < 1 || index > getSize())
		// {
			// System.out.println("invalid index!");
			// return;
		// }
		// if(index == 1)
		// {
			// deleteAtFront();
			// return;
		// }
		
		// Node current = head;
		// for(int i = 1; i < index - 1; i++)
		// {
			// current = current.next;
		// }
		// current.next = current.next.next;
		// if(current.next != null)
		// {
			// current.next.prev = current;
		// }
	// }
	
	// int search(int key)
	// {
		// Node current = head;
		// int position = 1;
		
		// while(current != null)
		// {
			// if(current.data == key)
			// {
				// return position;
			// }
			// current = current.next;
			// position++;
		// }
		// return -1;
	// }
// }
// public class DoublyLinkedList
// {
	// public static void main(String args[])
	// {
		// DoublyLinkedListADT linkedList = new DoublyLinkedListADT();
		
		// System.out.println(linkedList.isEmpty());
		
		// linkedList.insertAtFront(10);
		// linkedList.insertAtFront(20);
		// linkedList.insertAtFront(30);
		
		// linkedList.display();
	
		// System.out.println("1st element: "+linkedList.head.data); 
		// System.out.println("2nd element: "+linkedList.head.next.data); 
		// System.out.println("3rd element: "+linkedList.head.next.next.data);
	
		// System.out.println("LinkedList Size: "+linkedList.getSize());
		
		// linkedList.insertAtPosition(40,4);
		// linkedList.display();
		
		// linkedList.insertAtPosition(40,3);
		// linkedList.display();
		
		// linkedList.insertAtPosition(50,1);
		// linkedList.display();
		
		// linkedList.deleteAtEnd();
		// linkedList.display();
		
		// linkedList.deleteAtPosition(4);
		// linkedList.display();
		
		// linkedList.displayReverse();
	// }
// }