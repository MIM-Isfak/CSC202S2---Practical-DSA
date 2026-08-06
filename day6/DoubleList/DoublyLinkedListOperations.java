public class DoublyLinkedListOperations
{
	// 1. Reverse the linked list
	static <T> void reverseList(DoublyLinkedListADT<T> list)
	{
		if(list.isEmpty() || list.head.next == null)
		{
			return;
		}

		Node<T> current = list.head;
		Node<T> temp = null;

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
	static <T> void deleteKey(DoublyLinkedListADT<T> list, T key)
	{
		if(list.isEmpty())
		{
			System.out.println("linked list is empty!");
			return;
		}

		Node<T> current = list.head;
		while(current != null && !current.data.equals(key))
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
		// ---- Reverse - Integer type list ----
		DoublyLinkedListADT<Integer> l1 = new DoublyLinkedListADT<>();

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

		System.out.println();

		// ---- Delete key - Integer type list ----
		deleteKey(l1, 30);
		System.out.print("After deleting key 30: ");
		l1.display();

		deleteKey(l1, 999);

		System.out.println();

		// ---- Delete key - String type list ----
		DoublyLinkedListADT<String> l2 = new DoublyLinkedListADT<>();

		l2.insertAtEnd("Apple");
		l2.insertAtEnd("Banana");
		l2.insertAtEnd("Cherry");
		l2.insertAtEnd("Dragonfruit");

		System.out.print("Original list: ");
		l2.display();

		reverseList(l2);
		System.out.print("After reverse: ");
		l2.display();

		deleteKey(l2, "Cherry");
		System.out.print("After deleting key 'Cherry': ");
		l2.display();

		deleteKey(l2, "Mango");
	}
}