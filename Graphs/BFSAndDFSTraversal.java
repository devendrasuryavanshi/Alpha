package Graphs;

import java.util.*;

public class BFSAndDFSTraversal {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph) {// O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);// source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!visited[curr]) {
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {// O(V+E)
        // visit
        System.out.print(curr + " ");
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }

    // Hash Path? O(V+E)
    public static boolean hashPath(ArrayList<Edge>[] graph, boolean visited[], int src, int dest) {
        if(src == dest) {
            return true;
        }

        visited[src] = true;

        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);

            if(!visited[e.dest] && hashPath(graph, visited, e.dest, dest)) {
                return true;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int v = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[v];

        for(int i=0; i<v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));

        bfs(graph);
        System.out.println();
        dfs(graph, 0, new boolean[v]);
        System.out.println();

        boolean path = hashPath(graph, new boolean[v], 0, 5);

        System.out.println(path);
    }
}
