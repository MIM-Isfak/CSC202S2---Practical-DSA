public class GenericQueueArray<T>
{
    Object[] arr;
    int maxSize, front, rear;

    public GenericQueueArray(int maxSize)
    {
        this.maxSize = maxSize;
        arr = new Object[maxSize];
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

    public void enqueue(T value)
    {
        if (isFull())
        {
            System.out.println("Queue is full!");
            return;
        }
        arr[++rear] = value;
    }

    public T dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }

        T data = (T) arr[front];
        for (int i = 0; i < rear; i++)
        {
            arr[i] = arr[i + 1];
        }
        arr[rear--] = null;
        return data;
    }

    public T peek()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!");
            return null;
        }
        return (T) arr[front];
    }

    public static void main(String args[])
    {
        GenericQueueArray<String> qu = new GenericQueueArray<>(5);

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