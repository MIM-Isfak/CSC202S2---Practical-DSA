class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class AdjacencyListGraph
{
    private Node[] adjacencyList;
    private int numVertices;
    private int maxVertices;

    public AdjacencyListGraph(int maxVertices)
    {
        this.maxVertices = maxVertices;
        this.numVertices = 0;
        this.adjacencyList = new Node[maxVertices];
    }

    public boolean isEmpty()
    {
        return numVertices == 0;
    }

    public boolean isFull()
    {
        return numVertices == maxVertices;
    }

    private boolean isValidVertex(int v)
    {
        return v >= 0 && v < numVertices;
    }

    // insert a node
    public void insertNode()
    {
        if (isFull())
        {
            System.out.println("Graph is Full.");
            return;
        }
        numVertices++;
    }

    // insert an edge (insert at head: O(1))
    public void insertEdge(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            Node newNode = new Node(destination);
            newNode.next = adjacencyList[source];
            adjacencyList[source] = newNode;
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    // search an edge
    public boolean searchEdge(int source, int destination)
    {
        if (!isValidVertex(source) || !isValidVertex(destination))
        {
            return false;
        }

        Node current = adjacencyList[source];
        while (current != null)
        {
            if (current.data == destination)
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private void removeEdge(int source, int destination)
    {
        Node current = adjacencyList[source];
        Node prev = null;

        while (current != null)
        {
            if (current.data == destination)
            {
                if (prev == null)
                {
                    adjacencyList[source] = current.next;   // deleting the head
                }
                else
                {
                    prev.next = current.next;               // deleting middle or last
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // delete an edge
    public void deleteEdge(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            removeEdge(source, destination);
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    // delete a node (outgoing + incoming edges)
    public void deleteNode(int vertex)
    {
        if (isValidVertex(vertex))
        {
            adjacencyList[vertex] = null;             // outgoing edges

            for (int i = 0; i < numVertices; i++)     // incoming edges
            {
                removeEdge(i, vertex);
            }
        }
        else
        {
            System.out.println("invalid vertex.");
        }
    }

    // traverse all nodes
    public void traversal()
    {
        for (int i = 0; i < numVertices; i++)
        {
            System.out.print("vertex " + i + " connected to : ");
            Node current = adjacencyList[i];
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

public class GraphListQuestion
{
    public static void main(String[] args)
    {
        AdjacencyListGraph graph = new AdjacencyListGraph(5);

        // empty and full check at the beginning
        System.out.println("=== At the beginning ===");
        System.out.println("Is empty? " + graph.isEmpty());
        System.out.println("Is full?  " + graph.isFull());

        // 1. insert five nodes
        for (int i = 0; i < 5; i++)
        {
            graph.insertNode();
        }

        // 2. insert edges
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 2);
        graph.insertEdge(2, 3);
        graph.insertEdge(2, 1);
        graph.insertEdge(3, 4);
        graph.insertEdge(4, 1);
        graph.insertEdge(4, 3);

        System.out.println("\n=== Graph after inserting edges ===");
        graph.traversal();

        // 3. search edges
        System.out.println("\n=== Search ===");
        System.out.println("Edge 0->1 exists? " + graph.searchEdge(0, 1));
        System.out.println("Edge 1->3 exists? " + graph.searchEdge(1, 3));

        // 4. delete edge 0->1
        graph.deleteEdge(0, 1);
        System.out.println("\n=== After deleting edge 0->1 ===");
        graph.traversal();

        // 5. delete node 3
        graph.deleteNode(3);
        System.out.println("\n=== After deleting node 3 ===");

        // 6. traverse all nodes
        graph.traversal();

        // 7. empty and full check at the end
        System.out.println("\n=== At the end ===");
        System.out.println("Is empty? " + graph.isEmpty());
        System.out.println("Is full?  " + graph.isFull());
    }
}