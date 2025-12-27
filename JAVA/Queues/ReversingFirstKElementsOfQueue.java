package Queues;
import java.util.*;

public class ReversingFirstKElementsOfQueue {

    public static void reverseFirstK(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<k; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        for(int i=0; i<q.size()-k; i++) {
            q.add(q.remove());
        }
    }
    
    // Maximum of all subarrays of size k
    public static void maxInSubarray(int n, int k, int arr[]) {
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        for(int i=0; i<n; i++) {
            
            if(max <= arr[i]) {
                max = arr[i];
                q.add(max);
            }
        }
        
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        // reverseFirstK(q, 5);

        // System.out.println(q);
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        maxInSubarray(9, 3, arr);

    }
}
