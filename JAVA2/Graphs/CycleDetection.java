package Graphs;
import java.util.*;

public class CycleDetection {
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Undirected Graph
    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++) {
            if(!vis[i]) {
                if(detectCycleUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean vis[], int curr, int par) {
        vis[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // case - 3
            if(!vis[e.dest]) {
                if(detectCycleUtil(graph, vis, e.dest, curr)) {
                    return true;
                }
            }
            // case - 1
            else if(vis[e.dest] && e.dest != par) {
                return true;
            }
            //case - 2 -> do nothing -> continue
        }

        return false;
    }

    // Directed Graph
    public static boolean isCycle(ArrayList<Edge>[] grapg) {// O(V+E)
        boolean vis[] = new boolean[grapg.length];
        boolean stack[] = new boolean[grapg.length];

        for(int i=0; i<grapg.length; i++) {
            if(!vis[i]) {
                if(isCycleUtil(grapg, i, vis, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]) {
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest]) {// cycle
                return true;
            } else if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)) {
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
    
    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

        System.out.println(detectCycle(graph));

        int v2 = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph2 = new ArrayList[v2];

        for(int i=0; i<graph2.length; i++) {
            graph2[i] = new ArrayList<>();
        }

        // cycle
        // graph2[0].add(new Edge(0, 2));

        // graph2[1].add(new Edge(1, 0));

        // graph2[2].add(new Edge(2, 3));

        // graph2[3].add(new Edge(3, 0));

        //no cycle
        graph2[0].add(new Edge(0, 1));
        graph2[0].add(new Edge(0, 2));

        graph2[1].add(new Edge(1, 3));

        graph2[2].add(new Edge(2, 3));

        System.out.println(isCycle(graph2));
    }
}
