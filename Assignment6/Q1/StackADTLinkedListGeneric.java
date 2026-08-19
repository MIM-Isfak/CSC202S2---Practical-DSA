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

class StackLinkedList<T>
{
    Node<T> top;

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
        if (isEmpty())
        {
            System.out.println("Stack is empty.");
        }
        else
        {
            Node<T> current = top;
            System.out.print("Stack: ");
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void push(T data)
    {
        Node<T> newNode = new Node<>(data);

        if (isEmpty())
        {
            top = newNode;
        }
        else
        {
            newNode.next = top;
            top = newNode;
        }
    }

    public T pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return null;
        }
        else
        {
            T data = top.data;
            top = top.next;
            return data;
        }
    }

    public T peek()
    {
        if (isEmpty())
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

public class StackADTLinkedListGeneric
{
    public static void main(String[] args)
    {
        // Example with String
        StackLinkedList<String> st1 = new StackLinkedList<>();
        st1.push("Java");
        st1.push("Python");
        st1.push("C++");
        st1.display();
        System.out.println("Peek: " + st1.peek());
        System.out.println("Popped: " + st1.pop());
        st1.display();

        // Example with Integer
        StackLinkedList<Integer> st2 = new StackLinkedList<>();
        st2.push(10);
        st2.push(20);
        st2.push(30);
        st2.display();
        System.out.println("Popped: " + st2.pop());
        st2.display();
    }
}