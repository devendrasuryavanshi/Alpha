/*
 * Question:
 * How can we rearrange a linked list so that all even numbers appear before all odd numbers?
 * 
 * Explanation:
 * Given a linked list, we want to rearrange it such that all even numbers appear before all odd numbers,
 * while preserving the relative order of even and odd numbers.
 * We can solve this problem by iterating through the list and maintaining two pointers:
 * one for the even numbers and one for the odd numbers.
 * As we traverse the list, we move the nodes to their appropriate positions.
 * 
 * Algorithm Steps:
 * 1. Iterate through the list to find the first even and odd nodes.
 * 2. Handle the case when either even or odd nodes are not found.
 * 3. Adjust the head of the list if the first node is odd.
 * 4. Move the even pointer to the first even node and the odd pointer to the first odd node.
 * 5. Iterate through the list and swap nodes between even and odd sections while maintaining the order.
 * 
 * Example:
 * For the given linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9 -> 10
 * After rearranging: 2 -> 4 -> 6 -> 8 -> 10 -> 1 -> 3 -> 5 -> 7 -> 9
 * 
 * Time Complexity: O(N) - Where N is the number of nodes in the linked list.
 * Space Complexity: O(1) - Constant space is used.
 */

package LinkedList;

public class OddEven {

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
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
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

    // Function to rearrange the linked list so that even numbers appear before odd numbers
    public void oddEven() {
        Node even = null, odd = null;
        Node temp = head;

        // Find the first even node
        while (temp != null) {
            if (temp.data % 2 == 0) {
                even = temp;
                break;
            }
            temp = temp.next;
        }

        temp = head;
        // Find the first odd node
        while (temp != null) {
            if (temp.data % 2 != 0) {
                odd = temp;
                break;
            }
            temp = temp.next;
        }

        // Handle the case when either even or odd nodes are not found
        if (even == null || odd == null) {
            return;
        }

        // Adjust the head if the first node is odd
        if (odd == head) {
            Node evenNext = even.next;
            even.next = odd;
            odd.next = evenNext;
            head = even;
        }

        // Move pointers to the first even and odd nodes
        while (even.next != null && odd.next != null) {
            // Swap nodes between even and odd sections while maintaining the order
            if (even.next != null && odd.next != null && even.next.data % 2 != 0 && odd.next.data % 2 == 0) {
                Node next = even.next;
                even.next = odd.next;
                odd.next = odd.next.next;
                even.next.next = next;
            }
            // Move the even pointer
            if (even.next != null && even.next.data % 2 == 0) {
                even = even.next;
            }
            // Move the odd pointer
            if (odd.next != null && odd.next.data % 2 != 0) {
                odd = odd.next;
            }
        }
    }

    public static void main(String[] args) {
        OddEven ll = new OddEven();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        ll.addLast(7);
        ll.addLast(8);
        ll.addLast(9);
        ll.addLast(10);
        ll.print();
        ll.oddEven();
        ll.print();
    }
}
