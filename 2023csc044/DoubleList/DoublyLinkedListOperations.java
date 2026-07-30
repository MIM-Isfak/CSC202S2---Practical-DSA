public class DoublyLinkedListOperations
{
	// 1. Reverse the linked list
	static void reverseList(DoublyLinkedListADT list)
	{
		if(list.isEmpty() || list.head.next == null)
		{
			return;
		}
		
		Node current = list.head;
		Node temp = null;
		
		while(current != null)
		{
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		
		if(temp != null)
		{
			list.head = temp.prev;
		}
	}
	
	// 2. Deleting a given key from a linked list (which have multi type elements)
	static void deleteKey(DoublyLinkedListADT list, int key)
	{
		if(list.isEmpty())
		{
			System.out.println("linked list is empty!");
			return;
		}
		
		Node current = list.head;
		while(current != null && current.data != key)
		{
			current = current.next;
		}
		
		if(current == null)
		{
			System.out.println("Key " + key + " not found in the list!");
			return;
		}
		
		if(current == list.head)
		{
			list.deleteAtFront();
			return;
		}
		
		current.prev.next = current.next;
		if(current.next != null)
		{
			current.next.prev = current.prev;
		}
	}
	
	public static void main(String[] args)
	{
		DoublyLinkedListADT l1 = new DoublyLinkedListADT();
		
		l1.insertAtEnd(10);
		l1.insertAtEnd(20);
		l1.insertAtEnd(30);
		l1.insertAtEnd(40);
		l1.insertAtEnd(50);
		
		System.out.print("Original list: ");
		l1.display();
		
		reverseList(l1);
		System.out.print("After reverse: ");
		l1.display();
		
		deleteKey(l1, 30);
		System.out.print("After deleting key 30: ");
		l1.display();
		
		deleteKey(l1, 999);
	}
}