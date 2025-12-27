package Graphs;
import java.util.*;

public class Week14PS {
    public static void bfs(ArrayList<Integer> graph[], int src) {
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.remove();
            if(vis[u]) {
                System.out.println("We have a cycle at " + u + " " + graph[u]);
            }
            vis[u] = true;

            // System.out.print(u+" ");
            for(int nbr : graph[u]) {
                if(!vis[nbr]) {
                    q.add(nbr);
                }
            }
        }
    }

    public static void bfsLevel(ArrayList<Integer> graph[], int src) {
        int n = graph.length;
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(src);
        vis[src] = true;
        int level = 1;

        while (q.size() > 0) {
            int size = q.size();
            System.out.print("Level " + level + " ---> ");
            while (size > 0) {
                int u = q.remove();
                for(int nbr : graph[u]) {
                    if(!vis[nbr]) {
                        q.add(nbr);
                        vis[nbr] = true;
                        System.out.print(nbr + " ");
                    }
                }
                size--;
            }
            level++;
            System.out.println();
        }
    }
    public static void addEdge(ArrayList<Integer> graph[], int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }
    
    public static void main(String[] args) {
        // int n = 7;
        // @SuppressWarnings("unchecked")
        // ArrayList<Integer> graph[] = new ArrayList[n];

        // for(int i=0; i<n; i++) {
        //     graph[i] = new ArrayList<>();
        // }

        // addEdge(graph, 0, 1);
        // addEdge(graph, 0, 3);
        // addEdge(graph, 1, 2);
        // addEdge(graph, 1, 4);
        // addEdge(graph, 2, 3);
        // addEdge(graph, 4, 5);
        // addEdge(graph, 4, 6);
        // addEdge(graph, 5, 6);

        // bfs(graph, 0);
        // bfsLevel(graph, 0);

        // Adjacency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = 5;// vertices

        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(2);
        adjList.get(1).add(3);

        adjList.get(2).add(1);
        adjList.get(2).add(3);

        adjList.get(3).add(1);
        adjList.get(3).add(2);
        adjList.get(3).add(4);

        adjList.get(4).add(3);

        for(int i=1; i<n; i++) {
            System.out.print("["+i+"]");
            for(int j=0; j<adjList.get(i).size(); j++) {
                System.out.print(" --> " + adjList.get(i).get(j));
            }
            System.out.println();
        }

        //BFS
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];

        q.add(1);
        vis[1] = true;

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr+" ");
            for(int nbr : adjList.get(curr)) {
                if(!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
    }
}
