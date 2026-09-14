public class CircularQueueArray
{
    String[] arr;
    int maxSize, front, rear, count;

    public CircularQueueArray(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new String[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean isFull()
    {
        return count == maxSize;
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
            for (int i = 0; i < count; i++)
            {
                int index = (front + i) % maxSize;
                System.out.print(arr[index] + " ");
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
        rear = (rear + 1) % maxSize;
        arr[rear] = value;
        count++;
    }

    public String dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        String data = arr[front];
        arr[front] = null;
        front = (front + 1) % maxSize;
        count--;
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
        CircularQueueArray qu = new CircularQueueArray(5);

        qu.enqueue("A");
        qu.enqueue("B");
        qu.enqueue("C");
        qu.display(); 

        System.out.println("Dequeued: " + qu.dequeue());
        qu.display();        

        qu.enqueue("D");
        qu.enqueue("E");
        qu.enqueue("F");       
        qu.display();        

        System.out.println("Peek: " + qu.peek()); 

        qu.enqueue("G"); 
    }
}