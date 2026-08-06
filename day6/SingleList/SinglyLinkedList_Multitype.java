class Node<T>
{
    T data;
    Node<T> next;

    public Node(T data)
    {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedListADT<T>
{
    Node<T> head;

    public SinglyLinkedListADT()
    {
        this.head = null;
    }

    boolean isEmpty()
    {
        return head == null;
    }

    void insertAtFront(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }

    void display()
    {
        if (isEmpty())
        {
            System.out.println("Linked list is empty");
        }
        else
        {
            Node<T> current = head;
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    void insertAtEnd(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (isEmpty())
        {
            head = newNode;
        }
        else
        {
            Node<T> current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    int getSize()
    {
        int count = 0;
        Node<T> current = head;
        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    void insertAtPosition(T data, int index)
    {
        if (index < 1 || index > getSize() + 1)
        {
            System.out.println("invalid index!");
            return;
        }
        if (index == 1)
        {
            insertAtFront(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;
        for (int i = 1; i < index - 1; i++)
        {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    void deleteAtFront()
    {
        if (isEmpty())
        {
            System.out.println("link list is empty!");
        }
        else
        {
            head = head.next;
        }
    }

    void deleteAtEnd()
    {
        if (isEmpty())
        {
            System.out.println("linked list is empty!");
        }
        else if (head.next == null)
        {
            head = null;
        }
        else
        {
            Node<T> current = head;
            while (current.next.next != null)
            {
                current = current.next;
            }
            current.next = null;
        }
    }

    void deleteAtPosition(int index)
    {
        if (index < 1 || index > getSize())
        {
            System.out.println("invalid index!");
            return;
        }
        if (index == 1)
        {
            deleteAtFront();
            return;
        }

        Node<T> current = head;
        for (int i = 1; i < index - 1; i++)
        {
            current = current.next;
        }
        current.next = current.next.next;
    }

    int search(T key)
    {
        Node<T> current = head;
        int position = 1;

        while (current != null)
        {
            if (current.data.equals(key))
            {
                return position;
            }
            current = current.next;
            position++;
        }
        return -1;
    }
}