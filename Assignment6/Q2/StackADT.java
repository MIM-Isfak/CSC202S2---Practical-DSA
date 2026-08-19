class StackADT
{
	int maxSize;
	int[] stackArray;
	int top;
	
	
	public StackADT(int maxSize)
	{
		this.maxSize = maxSize;
		this.stackArray = new int [maxSize];
		this.top = -1; // Initialize the top of the stack to -1 (empty)
		
	}
	
	public boolean isEmpty()
	{
		return top == -1;
	}
	
	public boolean isFull()
	{
		return top == maxSize - 1;
	}
	
	public void display()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
		}
		else
		{
			System.out.println("Stack: ");
			for(int i=top; i>=0;i--)
			{
				System.out.println(stackArray[i]+" ");
			}
			System.out.println();
		}
	}
	
	public void push(int data)
	{
		
		if(isFull())
		{
			System.out.println("Stack is overflow" + data);
		}
		else
		{
			stackArray[++top] = data;
		}
		
	}
	
	public int pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty. Cannot pop.");
			return -1;
		}
		else
		{
			return stackArray[top--];
		}
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty.");
			return -1;
		}
		else
		{
			return stackArray[top];
		}
	}
	
}

// public class StackADTArray
// {
	// public static void main(String[] args)
	// {
	   // StackADT st =new StackADT(5);
	   
	   // st.isEmpty();
	    // st.push(10);
		// st.push(20);
		// st.push(30);
		// st.push(40);
		
		// st.pop();
		// st.pop();
		
		// st.display();
		// System.out.println(st.peek());
	// }
// }