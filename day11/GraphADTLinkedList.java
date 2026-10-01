class node
{
    node next;
    int data;

    public node(int data)
    {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList
{
    node AdjacencyList[];
    int numVertices;
    int maxVertices;

    public SinglyLinkedList(int maxVertices)
    {
        this.numVertices = 0;
        this.AdjacencyList = new node[maxVertices];
        this.maxVertices = maxVertices;
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

    public void insertVerticesGraph()
    {
        if (isFull())
        {
            System.out.println("Graph is Full.");
            return;
        }
        numVertices++;
    }

    public void insertEdgesGraph(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            node newnode = new node(destination);
            newnode.next = AdjacencyList[source];
            AdjacencyList[source] = newnode;

            // for undirected graph, uncomment the following lines
            // node reverseNode = new node(source);
            // reverseNode.next = AdjacencyList[destination];
            // AdjacencyList[destination] = reverseNode;
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
            node current = AdjacencyList[i];
            System.out.print("vertex " + i + " connected to : ");
            while (current != null)
            {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // helper: remove source -> destination (no validation)
    private void removeEdge(int source, int destination)
    {
        node current = AdjacencyList[source];
        node prev = null;

        while (current != null)
        {
            if (current.data == destination)
            {
                if (prev == null)
				{
					AdjacencyList[source] = current.next;   // head delete
				}   
                else
				{
					prev.next = current.next;   // middle / last delete
				}    
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void deleteEdgeGraph(int source, int destination)
    {
        if (isValidVertex(source) && isValidVertex(destination))
        {
            removeEdge(source, destination);
            // for undirected graph, uncomment the following line
            // removeEdge(destination, source);
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    public void deleteVerticesGraph(int vertex)
    {
        if (isValidVertex(vertex))
        {
            AdjacencyList[vertex] = null;   // outgoing edges
            for (int i = 0; i < numVertices; i++)     // incoming edges
            {
                removeEdge(i, vertex);
            }
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

        node current = AdjacencyList[source];
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

    // number of outgoing edges
    public int outDegree(int vertex)
    {
        if (!isValidVertex(vertex)) 
		{
			return -1;
		}
        int count = 0;
        node current = AdjacencyList[vertex];
        while (current != null)
        {
            count++;
            current = current.next;
        }
        return count;
    }

    // number of incoming edges (must scan all lists)
    public int inDegree(int vertex)
    {
        if (!isValidVertex(vertex))
		{
			return -1;
		}
        int count = 0;
        for (int i = 0; i < numVertices; i++)
		{
			if (isEdge(i, vertex)) count++;
			{
				return count;
			}
		}        
    }

    // total edges in the graph
    public int countEdges()
    {
        int total = 0;
        for (int i = 0; i < numVertices; i++)
		{
			total += outDegree(i);
		}   
        return total;
    }
}

public class GraphADTLinkedList
{
    public static void main(String args[])
    {
        SinglyLinkedList Adjacencylist = new SinglyLinkedList(4);
        Adjacencylist.insertVerticesGraph();
        Adjacencylist.insertVerticesGraph();
        Adjacencylist.insertVerticesGraph();
        Adjacencylist.insertVerticesGraph();

        Adjacencylist.insertEdgesGraph(0, 1);
        Adjacencylist.insertEdgesGraph(0, 2);
        Adjacencylist.insertEdgesGraph(1, 2);
        Adjacencylist.insertEdgesGraph(2, 3);

        System.out.println("--- Initial graph ---");
        Adjacencylist.traversalGraph();

        System.out.println("\n--- After deleting vertex 3 ---");
        Adjacencylist.deleteVerticesGraph(3);
        Adjacencylist.traversalGraph();

        System.out.println("\n--- After deleting edge 1 -> 2 ---");
        Adjacencylist.deleteEdgeGraph(1, 2);
        Adjacencylist.traversalGraph();

        System.out.println("\nIs there an edge 0 -> 1 ? " + Adjacencylist.isEdge(0, 1));
        System.out.println("Is there an edge 1 -> 3 ? " + Adjacencylist.isEdge(1, 3));
        System.out.println("outDegree(0) = " + Adjacencylist.outDegree(0));
        System.out.println("inDegree(2)  = " + Adjacencylist.inDegree(2));
        System.out.println("Total edges  = " + Adjacencylist.countEdges());
    }
}
