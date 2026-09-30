class AdjacencyMatrixGraph
{
    private int[][] matrix;
    private int numVertices;
    private int maxVertices;

    public AdjacencyMatrixGraph(int maxVertices)
    {
        this.maxVertices = maxVertices;
        this.numVertices = 0;
        this.matrix = new int[maxVertices][maxVertices];
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

    // insert an edge
    public void insertEdge(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            matrix[source][destination] = 1;
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
        return matrix[source][destination] != 0;
    }

    // delete an edge
    public void deleteEdge(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            matrix[source][destination] = 0;
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    // delete a node (removes its row and column)
    public void deleteNode(int vertex)
    {
        if (isValidVertex(vertex))
        {
            for (int i = 0; i < numVertices; i++)
            {
                matrix[i][vertex] = 0;   // incoming edges
                matrix[vertex][i] = 0;   // outgoing edges
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
            for (int j = 0; j < numVertices; j++)
            {
                if (matrix[i][j] != 0)
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
}

public class GraphMatrixQuestion
{
    public static void main(String[] args)
    {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(5);

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