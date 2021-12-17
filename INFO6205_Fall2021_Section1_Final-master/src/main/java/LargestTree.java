import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;
        for(int i = 0; i < adj[u].size() ; i++){
            if(!visited.get(adj[u].get(i))) {
                size += DFS(adj[u].get(i),adj,visited);
            }
        }
         return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        Vector<Boolean> marked = new Vector<>();
            for(int i = 0; i < V; i++)
            {marked.add(false);}
            int count = 0;
            for (int u = 0; u < V; u++)
            {
                if (marked.get(u) == false)
                {
                    count = Math.max(count,DFS(u, adj, marked));
                }
            }
            return count;
    }
}
