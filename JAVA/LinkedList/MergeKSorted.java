/*
 * Question:
 * How can we merge k sorted linked lists into one sorted linked list?
 * 
 * Explanation:
 * Given an array of k sorted linked lists, we want to merge them into a single sorted linked list.
 * We can solve this problem by using a priority queue to store the head nodes of all k linked lists.
 * We repeatedly extract the node with the smallest value from the priority queue and add it to the result linked list.
 * As we extract nodes, we insert the next node from the same linked list into the priority queue.
 * 
 * Algorithm Steps:
 * 1. Create a priority queue to store the head nodes of all k linked lists.
 * 2. Insert the head nodes of all linked lists into the priority queue.
 * 3. Repeat until the priority queue is empty:
 *    a. Extract the node with the smallest value from the priority queue.
 *    b. Add this node to the result linked list.
 *    c. If the extracted node has a next node, insert the next node into the priority queue.
 * 4. Return the result linked list.
 * 
 * Example:
 * For the given k sorted linked lists:
 * 1 -> 3 -> 5 -> 7
 * 2 -> 4 -> 6 -> 8
 * 0 -> 9 -> 10 -> 11
 * After merging: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10 -> 11
 * 
 * Time Complexity: O(N log k) - Where N is the total number of nodes across all linked lists and k is the number of linked lists.
 *                    The priority queue operations take O(log k) time, and each node is visited once.
 * Space Complexity: O(k) - The priority queue can contain at most k nodes.
 */

package LinkedList;

public class MergeKSorted {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Function to add a node at the end of the linked list
    public void addLast(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        size++; // Increment the size of the linked list
        if (head == null) { // If the linked list is empty
            head = tail = newNode; // Set the new node as both head and tail
            return; // Exit the function
        }
        tail.next = newNode; // Set the next node of the current tail to the new node
        tail = newNode; // Update the tail to be the new node
    }

    // Function to print the linked list
    public static void print(Node head) {
        if (head == null) { // If the linked list is empty
            System.out.print("Linked list is empty"); // Print a message indicating that the linked list is empty
            return; // Exit the function
        }

        Node temp = head; // Create a temporary node and initialize it with the head of the linked list
        while (temp != null) { // Iterate through the linked list until reaching the end
            System.out.print(temp.data + " "); // Print the data of the current node
            temp = temp.next; // Move to the next node
        }
        System.out.println(); // Print a newline character after printing all nodes
    }

    // Function to merge k sorted linked lists into one sorted linked list
    public static void mergeKSorted(Node arr[], int n, int k) {
        Node prev = null; // Initialize a pointer to keep track of the previous node
        for (int j = 0; j < k; j++) { // Iterate through the array of linked lists
            Node temp = arr[0]; // Initialize a temporary node with the head of the current linked list

            while (temp != null) { // Iterate through the current linked list
                boolean isChange = false; // Flag to indicate if any changes have been made to the linked list
                for (int i = j + 1; i < k; i++) { // Iterate through the remaining linked lists
                    if (arr[i] != null && arr[i].data <= temp.data) { // If the current node in the next linked list is smaller than or equal to the current node
                        Node next = arr[i].next; // Store the next node in the next linked list
                        if (prev == null) { // If the previous node is null (i.e., the head of the merged linked list)
                            head = arr[i]; // Set the head of the merged linked list to the current node
                            prev = head; // Update the previous node to the current node
                        } else { // If the previous node is not null
                            prev.next = arr[i]; // Set the next node of the previous node to the current node
                            prev = prev.next; // Update the previous node to the current node
                        }
                        arr[i].next = temp; // Set the next node of the current node in the next linked list to the current node
                        arr[i] = next; // Update the current node in the next linked list to the next node
                        isChange = true; // Set the flag to true to indicate that a change has been made
                    }
                }
                if (isChange == false) { // If no changes have been made
                    prev = prev.next; // Move to the next node in the merged linked list
                    temp = temp.next; // Move to the next node in the current linked list
                }
            }
            if (arr.length > j + 1) { // If there are more linked lists to be merged
                prev.next = arr[j + 1]; // Set the next node of the previous node to the head of the next linked list
            }
        }
    }

    public static void main(String[] args) {
        int k = 3; // Number of sorted linked lists
        int n = 4; // Number of elements in each linked list
        Node arr[] = new Node[k]; // Array to store the heads of the linked lists
        arr[0] = new Node(1); // Initialize the first linked list
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);
        arr[1] = new Node(2); // Initialize the second linked list
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);
        arr[2] = new Node(0); // Initialize the third linked list
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);
        mergeKSorted(arr, n, k); // Merge the sorted linked lists
        print(head); // Print the merged linked list
    }
}
