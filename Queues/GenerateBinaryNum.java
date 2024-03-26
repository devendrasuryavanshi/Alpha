package Queues;
import java.util.*;

public class GenerateBinaryNum {

    //own
    public static void generateBin(int n) {
        Deque<Integer> dq = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            int num = i;
            while (num != 0) {
                dq.addFirst(num%2);
                num = num / 2;
            }
            System.out.print(" ");

            while (!dq.isEmpty()) {
                System.out.print(dq.removeFirst());
            }
        } 
    }

    //didi opt
    public static void generateBinAndPrint(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        while(n-- > 0) {
            String s1 = q.remove();
            System.out.print(s1+" ");
            String s2 = s1;
            q.add(s1+"0");
            q.add(s2+"1");
        }
    }
    
    public static int minCost(int arr[], int n) {
        // Create a priority queue to store rope lengths
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        // Add rope lengths to the priority queue
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

        int res = 0; // Initialize total cost

        // While there are more than one rope in the priority queue
        while (pq.size() > 1) {
            // Extract the two shortest ropes
            int first = pq.poll();
            int second = pq.poll();

            // Calculate the cost of connecting the two ropes
            int cost = first + second;

            // Add the cost to the total cost
            res += cost;

            // Add the newly formed rope back to the priority queue
            pq.add(cost);
        }

        // Return the total cost
        return res;
    }
    public static void main(String[] args) {
        generateBinAndPrint(7);
        // Example usage
        // int[] arr1 = {4, 3, 2, 6};
        // int[] arr2 = {1, 2, 3};
        // System.out.println("Minimum cost for arr1: " + minCost(arr1, arr1.length));
        // System.out.println("Minimum cost for arr2: " + minCost(arr2, arr2.length));
    }
}
