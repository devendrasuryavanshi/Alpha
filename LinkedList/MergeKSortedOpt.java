/*
 * Question:
 * How can we merge k sorted linked lists into one sorted linked list?
 * 
 * Explanation:
 * Given an array of k sorted linked lists, we want to merge them into one sorted linked list.
 * We can solve this problem by repeatedly merging pairs of linked lists until only one linked list remains.
 * To merge two sorted linked lists, we can use a modified version of the merge operation of merge sort.
 * 
 * Algorithm Steps:
 * 1. Define a function SortedMerge(Node a, Node b) to merge two sorted linked lists.
 * 2. Initialize a result node as null.
 * 3. If either of the linked lists is null, return the other linked list.
 * 4. Compare the data of the first nodes of both linked lists.
 * 5. Assign the smaller node as the result and recursively merge the remaining nodes.
 * 6. Define a function mergeKLists(Node arr[], int last) to merge k sorted linked lists.
 * 7. Iterate until only one linked list remains in the array.
 * 8. Merge pairs of linked lists by calling the SortedMerge function.
 * 9. Update the 'last' index to the last index with a linked list after each iteration.
 * 
 * Example:
 * For the given array of linked lists:
 * List 1: 1 -> 3 -> 5 -> 7
 * List 2: 2 -> 4 -> 6 -> 8
 * List 3: 0 -> 9 -> 10 -> 11
 * After merging: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11
 * 
 * Time Complexity: O(N*log(k)) - Where N is the total number of elements in all k linked lists.
 *                                   Merging two sorted linked lists takes O(N) time, and there are log(k) levels of merging.
 * Space Complexity: O(1) - Constant space is used.
 */
package LinkedList;

 public class MergeKSortedOpt {
    // Function to merge two sorted linked lists
    public static Node SortedMerge(Node a, Node b) {
        Node result = null; // Initialize the result node as null
        if (a == null) // If the first linked list is null, return the second linked list
            return b;
        else if (b == null) // If the second linked list is null, return the first linked list
            return a;
        
        // Compare the data of the first nodes of both linked lists
        if (a.data <= b.data) {
            result = a; // Assign the first node of the first linked list as the result
            result.next = SortedMerge(a.next, b); // Recursively merge the remaining nodes
        } else {
            result = b; // Assign the first node of the second linked list as the result
            result.next = SortedMerge(a, b.next); // Recursively merge the remaining nodes
        }
        return result; // Return the merged linked list
    }
    
    // Function to merge k sorted linked lists
    public static Node mergeKLists(Node arr[], int last) {
        while (last != 0) { // Iterate until only one linked list remains in the array
            int i = 0, j = last;
            while (i < j) { // Iterate over pairs of linked lists
                arr[i] = SortedMerge(arr[i], arr[j]); // Merge the current pair of linked lists
                i++;
                j--;
                if (i >= j) // If all pairs have been merged, update 'last' to the last index with a linked list
                    last = j;
            }
        }
        return arr[0]; // Return the merged linked list
    }
    
    // Function to print the linked list
    public static void printList(Node node) {
        while (node != null) { // Iterate through the linked list
            System.out.print(node.data + " "); // Print the data of the current node
            node = node.next; // Move to the next node
        }
    }
    
    // Main method
    public static void main(String args[]) {
        int k = 3; // Number of sorted linked lists
        int n = 4; // Number of elements in each linked list
        Node arr[] = new Node[k]; // Array to store the heads of the linked lists
        
        // Initialize the linked lists
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
        
        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
        
        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        
        Node head = mergeKLists(arr, k - 1); // Merge the sorted linked lists
        printList(head); // Print the merged linked list
    }
}

// Class representing a node in a linked list
class Node {
    int data; // Data of the node
    Node next; // Reference to the next node
    
    // Constructor to initialize the node with given data
    Node(int data) {
        this.data = data;
    }
}
