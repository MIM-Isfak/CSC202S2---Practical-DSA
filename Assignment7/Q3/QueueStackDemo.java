public class QueueStackDemo
{
    // Removes the first K elements of the queue, reverses their order
    // using a stack, and re-adds them to the back of the same queue.
    public static void reverseFirstK(QueueADTArray queue, int k)
    {
        if (queue.isEmpty() || k <= 0)
        {
            return;
        }

        StackADTArray stack = new StackADTArray(k);

        for (int i = 0; i < k; i++)
        {
            String value = queue.dequeue();
            stack.push(Integer.parseInt(value));
        }

        for (int i = 0; i < k; i++)
        {
            int value = stack.pop();
            queue.enqueue(String.valueOf(value));
        }
    }

    public static void main(String[] args)
    {
        QueueADTArray qu = new QueueADTArray(10);

        qu.enqueue("10");
        qu.enqueue("20");
        qu.enqueue("30");
        qu.enqueue("40");
        qu.enqueue("50");

        System.out.println("Before:");
        qu.display();

        reverseFirstK(qu, 3);

        System.out.println("After reversing first 3:");
        qu.display(); 
    }
}