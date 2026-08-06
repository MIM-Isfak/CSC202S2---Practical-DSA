public class SinglyLinkedListOperations
{
	// 1. Reverse a linked list and display the elements.
	static <T> void reverseList(SinglyLinkedListADT<T> list)
	{
		if(list.isEmpty() || list.head.next == null)
		{
			return;
		}

		Node<T> prev = null;
		Node<T> current = list.head;
		Node<T> next = null;

		while(current != null)
		{
			next = current.next;   // save the next node before overwriting
			current.next = prev;   // reverse this node's link
			prev = current;        // advance prev
			current = next;        // advance current
		}

		list.head = prev;  // prev is the new first node
	}

	// 2. Deleting a given key from a linked list (which have multi type elements)
	static <T> void deleteKey(SinglyLinkedListADT<T> list, T key)
	{
		if(list.isEmpty())
		{
			System.out.println("linked list is empty!");
			return;
		}

		Node<T> current = list.head;
		Node<T> prev = null;

		while(current != null && !current.data.equals(key))
		{
			prev = current;
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

		prev.next = current.next;  // unlink current, skipping over it
	}

	public static void main(String[] args)
	{
		// ---- Reverse - Integer type list ----
		SinglyLinkedListADT<Integer> l1 = new SinglyLinkedListADT<>();

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
		SinglyLinkedListADT<String> l2 = new SinglyLinkedListADT<>();

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