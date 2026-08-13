class Node
{
	String data;
	Node next;
	
	public Node(String data)
	{
		this.data = data;
		this.next = null;
	}
	
}

class StackLinkedList
{
	Node top;
	
	public StackLinkedList()
	{
		this.top = null;
	}
	
	public boolean isEmpty()
    {
	   return top == null;
    }
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
		}
		else
		{
			Node current = top;
			System.out.print("Stack: ");
			while(current != null)
			{
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		}
	}
  
	public void push(String data)
	{
	 
		Node newNode= new Node(data);
		
		
		if(isEmpty())
		{
			top = newNode;
		}
		else
		{
			// top.next = newNode; //if we write like this we can't display
			// top = top.next;	  // because we cant display singly linked list from -> (left to right) 
			newNode.next = top;
		    top = newNode;
		} 
	}
	
	public String pop()
	 {
		 if(isEmpty())
		 {
			 System.out.println("Stack is empty");
			 return null;
		 }
		 else
		 {
			 String data = top.data;
			 top = top.next;
			 return data;
		 }
	 }
	 
	 public String peek()
	 {
		 if(isEmpty())
		 {
			 System.out.println("Stack is empty");
			 return null;
		 }
		 else
		 {
			 return top.data;
		 }
	 }
}


// public class StackADTLinkedList
// {
    // public static void main(String[] args)
    // {
        // StackLinkedList st = new StackLinkedList();

        // st.push("Java");
        // st.push("Python");
        // st.push("C++");

        // st.display();
        // System.out.println("Peek: " + st.peek());
        // System.out.println("Popped: " + st.pop());
        // st.display();
    // }
// }