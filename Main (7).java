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
class Graph 
{
    int V;
    Node aL[];
    public Graph(int V) 
    {
        this.V = V;
        aL = new Node[V];
        for (int i = 0; i < V; i++) 
        {
            aL[i] = null;
        }
    }
    // Function to add an edge to the graph
    public void edge(int src, int d) {
        Node newNode = new Node(d);
        newNode.next = aL[src];
        aL[src] = newNode;

        // If it's an undirected graph, add the reverse edge as well
        newNode = new Node(src);
        newNode.next = aL[d];
        aL[d] = newNode;
    }
    // Depth-First Search traversal from a given source vertex
    public void DFS(int source) 
    {
        boolean[] vis = new boolean[V];
        DFSRecursive(source, vis);
    }
    private void DFSRecursive(int vertex, boolean[] vis) 
    {
        vis[vertex] = true;
        System.out.print(vertex + " ");
        Node M = aL[vertex];
        while (M != null) 
        {
            int neighbor = M.data;
            if (!vis[neighbor]) 
            {
                DFSRecursive(neighbor, vis);
            }
            M = M.next;
        }
    }
}
public class Main 
{
    public static void main(String[] args) 
    {
        // Create a graph with 6 vertices (0 to 5)
        Graph G = new Graph(6);

        // Add edges to the graph
        G.edge(0, 1);
        G.edge(0, 2);
        G.edge(1, 3);
        G.edge(2, 3);
        G.edge(2, 4);
        G.edge(3, 4);
        G.edge(3, 5);
        G.edge(4, 5);

        System.out.println("DFS Traversal starting from vertex 0:");
       G.DFS(0); // Should print "0 1 3 2 4 5"
    }
}
