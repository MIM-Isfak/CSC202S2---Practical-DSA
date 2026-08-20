class QueueADTArray
{
    String[] arr;
    int maxSize, front, rear;
    
    public QueueADTArray(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new String[maxSize];
        front = 0;
        rear = -1;
    }
    
    public boolean isEmpty()
    {
        return rear == -1;
    }
    
    public boolean isFull()
    {
        return rear == maxSize - 1;
    }
	
	public void display()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
        }
        else
        {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++)
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    
    public void enqueue(String value)
    {
        if (isFull())
        {
            System.out.println("Queue is full!");
            return;
        }
        arr[++rear] = value;
    }
    
    public String dequeue()
    {
        // if (isEmpty())
        // {
            // System.out.println("Queue is empty!");
            // return null;
        // }
        // String value = arr[front];
        // arr[front] = null;
        // front++;
        
        // if (front > rear)
        // {
            // front = 0;
            // rear = -1;
        // }
        // return value;
		
		String data = arr[front];
		for(int i=0; i<rear; i++)
		{
			arr[i] = arr[i+1];
		}
		arr[rear--] = "";
		return data;
    }
    
    public String peek()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        return arr[front];
    }
    
    
    public static void main(String args[])
    {
        QueueADTArray qu = new QueueADTArray(5);
        
        qu.enqueue("A");
        qu.enqueue("B");
        qu.enqueue("C");
        qu.display();             
        
        System.out.println("Dequeued: " + qu.dequeue());
        qu.display();           
        
        System.out.println("Peek: " + qu.peek());        
        
        qu.enqueue("D");
        qu.enqueue("E");
        qu.enqueue("F");    
        qu.display();
    }
}