class AdjacencyArrayADT
{
    private int[][] adjacencyMatrix;
    private int numVertices;
    private int maxVertices;

    public AdjacencyArrayADT(int maxVertices)
    {
        this.numVertices = 0;
        this.maxVertices = maxVertices;
        this.adjacencyMatrix = new int[maxVertices][maxVertices];
    }

    public boolean isEmpty()
    {
        return numVertices == 0;
    }

    public boolean isFull()
    {
        return numVertices == maxVertices;
    }

    public int getNumVertices()
    {
        return numVertices;
    }

    private boolean isValidVertex(int v)
    {
        return v >= 0 && v < numVertices;
    }

    public void insertVerticesGraph()
    {
        if (isFull())
        {
            System.out.println("Graph is Full.");
            return;
        }
        numVertices++;
    }

    public void insertEdgesGraph(int source, int destination, int weight)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            adjacencyMatrix[source][destination] = weight;
            // for undirected graph, uncomment the following line
            // adjacencyMatrix[destination][source] = weight;
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    public void traversalGraph()
    {
        for (int i = 0; i < numVertices; i++)
        {
            System.out.print("vertex " + i + " connected to : ");
            for (int j = 0; j < numVertices; j++)
            {
                if (adjacencyMatrix[i][j] != 0)
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
		}
    }

    public void deleteVerticesGraph(int vertex)
    {
        if (isValidVertex(vertex))
        {
            for (int i = 0; i < numVertices; i++)
            {
                adjacencyMatrix[i][vertex] = 0;   // incoming edges (column)
                adjacencyMatrix[vertex][i] = 0;   // outgoing edges (row)
            }
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    public void deleteEdgeGraph(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            adjacencyMatrix[source][destination] = 0;
            // for undirected graph, uncomment the following line
            // adjacencyMatrix[destination][source] = 0;
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    public boolean isEdge(int source, int destination)
    {
        if (!isValidVertex(source) || !isValidVertex(destination))
        {
            return false;
        }
        return adjacencyMatrix[source][destination] != 0;
    }
}

public class GraphADTAdjacencyMatrix
{
    public static void main(String[] args)
    {
        AdjacencyArrayADT graph = new AdjacencyArrayADT(4);

        graph.insertVerticesGraph();
        graph.insertVerticesGraph();
        graph.insertVerticesGraph();
        graph.insertVerticesGraph();

        graph.insertEdgesGraph(0, 1, 5);
        graph.insertEdgesGraph(0, 2, 15);
        graph.insertEdgesGraph(1, 2, 25);
        graph.insertEdgesGraph(2, 3, 10);

        System.out.println("--- Initial graph ---");
        graph.traversalGraph();

        System.out.println("\n--- After deleting vertex 3 ---");
        graph.deleteVerticesGraph(3);
        graph.traversalGraph();

        System.out.println("\n--- After deleting edge 1 -> 2 ---");
        graph.deleteEdgeGraph(1, 2);
        graph.traversalGraph();

        System.out.println("\nIs there an edge 1 -> 3 ? " + graph.isEdge(1, 3));
        System.out.println("Is there an edge 0 -> 1 ? " + graph.isEdge(0, 1));
    }
}