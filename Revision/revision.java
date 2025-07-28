package Revision;

import java.util.*;

public class revision {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void bfs(ArrayList<Edge> graph[]) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];

        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()) {
            int curr = q.remove();
            System.out.println(curr);
            for(Edge e : graph[curr]) {
                if(!vis[e.dest]) {
                    q.add(e.dest);
                    vis[e.dest] = true;
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], boolean vis[], int src) {
        vis[src] = true;
        System.out.print(src);
        for(Edge e : graph[src]) {
            if(!vis[e.dest]) {
                dfs(graph, vis, e.dest);
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<Edge> graph[] = new ArrayList[5];
        for(int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 5));

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 3));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        graph[4].add(new Edge(4, 2, 2));

        bfs(graph);
        boolean vis[] = new boolean[graph.length];
        dfs(graph, vis, 4);
    }
}