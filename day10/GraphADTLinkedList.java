class node
{
	node next;
	int data;
	
	public node(int data)
	{
		this.data=data;
		this.next=null;
	}
}

class SinglyLinkedList()
{
	node AdjacencyList[];
	int numVertices;
	int maxVertices;
	
	public SinglyLinkedList(int maxVertices)
	{
		this.numVertices=0;
		this.AdjacencyList = new node[maxVertices];
		this.maxVertices=maxVertices;
	}
	public void isEmpty()
	{
		return numVertices==0;
	}
	public boolean isFull()
	{
		return numVertices==maxVertices;
	}
	
	public void insertVerticesGraph()
	{
		if(isFull())
		{
			System.out.println("Graph is Full.");
			return;
		}
		numVertices++;
	}
	
	public void insertEdgesGraph(int source,int destination)
	{
		if(source >= 0 && source < numVertices && destination >= 0 && destination<numVertices)
		{
			node newnode = new node(destination);
			newnode.next = AdjacencyList[source];
		    AdjacencyList[source] = newnode;
			 
			//for undirected graph , uncomment the following line
			//node newnode = new node(source);
			//newnode.next = AdjacencyList[destination];
		    //AdjacencyList[destination] = newnode;
		}
		else
		{
		    System.out.println("invalid vertices.");
		}
	}
	
	public void traversalGraph()
	{
	    for(int i=0; i<numVertices;i++)
		{
			node current = AdjacencyList[i];
			System.out.println("vertex " + i + "connected to : ");
			while(current!=0)
			{
				System.out.println(current.data+"");
				current=current.next;
			}
		}
		System.out.println();
	}
	
	public void deleteVerticesGraph(int vertex)
	{
		if(vertex>=0 && vertex<numVertices)
		{
			for(int i=0 ; i<numVertices;i++)
		    {
		        AdjacencyMatrix[i][vertex] = 0;
		        AdjacencyMatrix[vertex][i] = 0;
		    }
		}
        else
		{
			System.out.println("invalid vertices.");
		}		
	}
	
	public void deleteEdgeGraph(int source,int destination)
	{
		if(source >= 0 && source < numVertices && destination >= 0 && destination<numVertices)
		{
		    AdjacencyMatrix[source][destination] = 0;
			//for undirected graph ,uncomment following line
			//AdjacencyMatrix[destination][source] = 0;
		}
		else
		{
			System.out.println("invalid edges.");
		}
	}
    public boolean isEdge(int source,int destination)
	{
		return AdjacencyMatrix[source][destination]! = 0;
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
		
		
		Adjacencylist.insertEdgesGraph(0,1);
		Adjacencylist.insertEdgesGraph(0,2);
		Adjacencylist.insertEdgesGraph(1,2);
		Adjacencylist.insertEdgesGraph(2,3);

		Adjacencylist.traversalGraph();
		
		System.out.println();
		
		Adjacencylist.deleteVerticesGraph(3);
		Adjacencylist.traversalGraph();
		System.out.println();
		
		
	}
}
