/*
 * Question:
 * How can we swap nodes in a linked list given their values?
 * 
 * Explanation:
 * Given a linked list and two values, we want to swap the nodes with these values in the linked list.
 * We can solve this problem by traversing the linked list to find the nodes with the given values.
 * Once found, we swap the positions of these nodes by adjusting the pointers.
 * 
 * Algorithm Steps:
 * 1. Traverse the linked list to find the nodes with the given values (x and y).
 * 2. Keep track of the previous nodes of the found nodes.
 * 3. If any of the nodes is not found, return.
 * 4. Update the previous nodes to point to the new positions of the swapped nodes.
 * 5. Swap the next pointers of the found nodes to complete the swap.
 * 
 * Example:
 * For the given linked list: 1 -> 2 -> 3 -> 4 -> 5
 * After swapping nodes with values 2 and 4: 1 -> 4 -> 3 -> 2 -> 5
 * 
 * Time Complexity: O(N) - Where N is the number of nodes in the linked list.
 * Space Complexity: O(1) - Constant space is used.
 */

package LinkedList;

import java.util.List;

public class SwapNodes {

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

    // Function to add a node at the beginning of the linked list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Function to swap nodes in the linked list given their values
    public void swapNodes(int x, int y) {
        Node currX = head, currY = head;

        Node prevX = null, prevY = null;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
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
        SwapNodes list = new SwapNodes();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.print();
        list.swapNodes(2, 4);
        list.print();
    }
}
