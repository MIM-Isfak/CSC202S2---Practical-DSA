public class QueueInterleaveDemo
{
    public static int getSize(QueueADTLinkedList queue)
    {
        int count = 0;
        Node temp = queue.front;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void interleave(QueueADTLinkedList queue)
    {
        int size = getSize(queue);
        int half = size / 2;

        QueueADTLinkedList firstHalf = new QueueADTLinkedList();
        QueueADTLinkedList secondHalf = new QueueADTLinkedList();

        for (int i = 0; i < half; i++)
        {
            firstHalf.enqueue(queue.dequeue());
        }
        for (int i = 0; i < size - half; i++)
        {
            secondHalf.enqueue(queue.dequeue());
        }

        while (!firstHalf.isEmpty() && !secondHalf.isEmpty())
        {
            queue.enqueue(firstHalf.dequeue());
            queue.enqueue(secondHalf.dequeue());
        }

        while (!secondHalf.isEmpty())
        {
            queue.enqueue(secondHalf.dequeue());
        }
        while (!firstHalf.isEmpty())
        {
            queue.enqueue(firstHalf.dequeue());
        }
    }

    public static void main(String[] args)
    {
        QueueADTLinkedList qu = new QueueADTLinkedList();

        qu.enqueue(1);
        qu.enqueue(2);
        qu.enqueue(3);
        qu.enqueue(4);
        qu.enqueue(5);
        qu.enqueue(6);

        System.out.println("Before:");
        qu.display();

        interleave(qu);

        System.out.println("After interleaving:");
        qu.display();
    }
}