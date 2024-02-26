/*
 * Question:
 * How can we delete N nodes after M nodes in a linked list?
 * 
 * Explanation:
 * Given a linked list, we want to delete N nodes after every M nodes.
 * We can achieve this by traversing the linked list and adjusting pointers accordingly to skip the nodes.
 * 
 * Algorithm Steps:
 * 1. Start from the head of the linked list.
 * 2. Traverse M nodes, then:
 *    a. Skip the next N nodes by adjusting pointers.
 *    b. Continue traversing the list from the skipped node.
 * 3. Repeat steps 2 until the end of the list is reached.
 * 
 * Example:
 * For the given linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
 * After deleting 2 nodes after every 2 nodes: 1 -> 2 -> 5 -> 6
 * 
 * Time Complexity: O(N) - Where N is the number of nodes in the linked list.
 * Space Complexity: O(1) - Constant space is used.
 */

package LinkedList;

public class DeleteNnodesafterMnodes {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Global variables for head and tail of the linked list
    public static Node head;
    public static Node tail;

    // Function to add a node at the end of the linked list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // Function to delete N nodes after every M nodes in the linked list
    public void deleteNnodesafterMnodes(int m, int n) {
        Node curr = head, t;
        while (curr != null) {
            // Traverse M nodes
            for (int i = 1; i < m && curr != null; i++) {
                curr = curr.next;
            }
            // Return if end of list is reached
            if (curr == null) {
                return;
            }
            t = curr.next; // Store the next node after M nodes
            // Skip N nodes
            for (int i = 1; i <= n && t != null; i++) {
                t = t.next;
            }
            curr.next = t; // Adjust pointers to skip N nodes
            curr = t; // Move to the next node after the skipped nodes
        }
    }

    // Function to print the linked list
    public void print() {
        if (head == null) {
            System.out.print("Linked list is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
     
    public static void main(String[] args) {
        DeleteNnodesafterMnodes ll = new DeleteNnodesafterMnodes();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.print();
        ll.deleteNnodesafterMnodes(2, 2);
        ll.print();
    }
}
