class GraphUtil
{
    static final int INF = Integer.MAX_VALUE;

    static void printPath(int[] parent, int v)
    {
        if (parent[v] == -1)
        {
            System.out.print(v);
            return;
        }
        printPath(parent, parent[v]);
        System.out.print(" -> " + v);
    }

    static void printDijkstra(int[] dist, int[] parent, int n)
    {
        for (int v = 0; v < n; v++)
        {
            if (dist[v] == INF)
            {
                System.out.println("vertex " + v + " : unreachable");
            }
            else
            {
                System.out.print("vertex " + v + " : distance " + dist[v] + ", path ");
                printPath(parent, v);
                System.out.println();
            }
        }
    }
}

// ================= ADJACENCY MATRIX =================
class MatrixGraph
{
    private int[][] matrix;
    private int numVertices;
    private int maxVertices;

    public MatrixGraph(int maxVertices)
    {
        this.maxVertices = maxVertices;
        this.numVertices = 0;
        this.matrix = new int[maxVertices][maxVertices];
    }

    public void insertNode()
    {
        if (numVertices == maxVertices)
        {
            System.out.println("Graph is Full.");
            return;
        }
        numVertices++;
    }

    public void insertEdge(int source, int destination, int weight)
    {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices)
        {
            matrix[source][destination] = weight;
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    // ---------- DFS ----------
    public void dfs(int start)
    {
        boolean[] visited = new boolean[numVertices];
        dfsVisit(start, visited);
        System.out.println();
    }

    private void dfsVisit(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        for (int j = 0; j < numVertices; j++)
        {
            if (matrix[v][j] != 0 && !visited[j])
            {
                dfsVisit(j, visited);
            }
        }
    }

    // ---------- BFS ----------
    public void bfs(int start)
    {
        boolean[] visited = new boolean[numVertices];
        int[] queue = new int[numVertices];
        int front = 0, rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        while (front < rear)
        {
            int v = queue[front++];
            System.out.print(v + " ");
            for (int j = 0; j < numVertices; j++)
            {
                if (matrix[v][j] != 0 && !visited[j])
                {
                    visited[j] = true;
                    queue[rear++] = j;
                }
            }
        }
        System.out.println();
    }

    // ---------- Dijkstra ----------
    public void dijkstra(int start)
    {
        int[] dist = new int[numVertices];
        int[] parent = new int[numVertices];
        boolean[] done = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++)
        {
            dist[i] = GraphUtil.INF;
            parent[i] = -1;
        }
        dist[start] = 0;

        for (int count = 0; count < numVertices; count++)
        {
            // pick the unfinished vertex with the smallest distance
            int u = -1;
            for (int i = 0; i < numVertices; i++)
            {
                if (!done[i] && dist[i] != GraphUtil.INF && (u == -1 || dist[i] < dist[u]))
                {
                    u = i;
                }
            }
            if (u == -1) break;   // remaining vertices are unreachable
            done[u] = true;

            // relax edges from u
            for (int v = 0; v < numVertices; v++)
            {
                if (matrix[u][v] != 0 && !done[v] && dist[u] + matrix[u][v] < dist[v])
                {
                    dist[v] = dist[u] + matrix[u][v];
                    parent[v] = u;
                }
            }
        }
        GraphUtil.printDijkstra(dist, parent, numVertices);
    }
}

// ================= ADJACENCY LIST =================
class ListNode
{
    int data;
    int weight;
    ListNode next;

    public ListNode(int data, int weight)
    {
        this.data = data;
        this.weight = weight;
        this.next = null;
    }
}

class ListGraph
{
    private ListNode[] adjacencyList;
    private int numVertices;
    private int maxVertices;

    public ListGraph(int maxVertices)
    {
        this.maxVertices = maxVertices;
        this.numVertices = 0;
        this.adjacencyList = new ListNode[maxVertices];
    }

    public void insertNode()
    {
        if (numVertices == maxVertices)
        {
            System.out.println("Graph is Full.");
            return;
        }
        numVertices++;
    }

    public void insertEdge(int source, int destination, int weight)
    {
        if (source >= 0 && source < numVertices && destination >= 0 && destination < numVertices)
        {
            ListNode newNode = new ListNode(destination, weight);
            newNode.next = adjacencyList[source];   // head insertion
            adjacencyList[source] = newNode;
        }
        else
        {
            System.out.println("invalid vertices.");
        }
    }

    // ---------- DFS ----------
    public void dfs(int start)
    {
        boolean[] visited = new boolean[numVertices];
        dfsVisit(start, visited);
        System.out.println();
    }

    private void dfsVisit(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        ListNode current = adjacencyList[v];
        while (current != null)
        {
            if (!visited[current.data])
            {
                dfsVisit(current.data, visited);
            }
            current = current.next;
        }
    }

    // ---------- BFS ----------
    public void bfs(int start)
    {
        boolean[] visited = new boolean[numVertices];
        int[] queue = new int[numVertices];
        int front = 0, rear = 0;

        visited[start] = true;
        queue[rear++] = start;

        while (front < rear)
        {
            int v = queue[front++];
            System.out.print(v + " ");
            ListNode current = adjacencyList[v];
            while (current != null)
            {
                if (!visited[current.data])
                {
                    visited[current.data] = true;
                    queue[rear++] = current.data;
                }
                current = current.next;
            }
        }
        System.out.println();
    }

    // ---------- Dijkstra ----------
    public void dijkstra(int start)
    {
        int[] dist = new int[numVertices];
        int[] parent = new int[numVertices];
        boolean[] done = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++)
        {
            dist[i] = GraphUtil.INF;
            parent[i] = -1;
        }
        dist[start] = 0;

        for (int count = 0; count < numVertices; count++)
        {
            int u = -1;
            for (int i = 0; i < numVertices; i++)
            {
                if (!done[i] && dist[i] != GraphUtil.INF && (u == -1 || dist[i] < dist[u]))
                {
                    u = i;
                }
            }
            if (u == -1) break;
            done[u] = true;

            ListNode current = adjacencyList[u];
            while (current != null)
            {
                int v = current.data;
                if (!done[v] && dist[u] + current.weight < dist[v])
                {
                    dist[v] = dist[u] + current.weight;
                    parent[v] = u;
                }
                current = current.next;
            }
        }
        GraphUtil.printDijkstra(dist, parent, numVertices);
    }
}

public class GraphSearchMathods
{
    public static void main(String[] args)
    {
        MatrixGraph matrixGraph = new MatrixGraph(5);
        ListGraph listGraph = new ListGraph(5);

        for (int i = 0; i < 5; i++)
        {
            matrixGraph.insertNode();
            listGraph.insertNode();
        }

        // source, destination, weight
        int[][] edges = {
            {0, 1, 4}, {0, 2, 1}, {1, 2, 2}, {2, 3, 5},
            {2, 1, 2}, {3, 4, 3}, {4, 1, 1}, {4, 3, 6}
        };

        for (int[] e : edges)
        {
            matrixGraph.insertEdge(e[0], e[1], e[2]);
            listGraph.insertEdge(e[0], e[1], e[2]);
        }

        System.out.print("DFS (Matrix) from 0 : ");
        matrixGraph.dfs(0);
        System.out.print("DFS (List)   from 0 : ");
        listGraph.dfs(0);

        System.out.print("\nBFS (Matrix) from 0 : ");
        matrixGraph.bfs(0);
        System.out.print("BFS (List)   from 0 : ");
        listGraph.bfs(0);

        System.out.println("\nDijkstra (Matrix) from 0:");
        matrixGraph.dijkstra(0);
        System.out.println("\nDijkstra (List) from 0:");
        listGraph.dijkstra(0);
    }
}