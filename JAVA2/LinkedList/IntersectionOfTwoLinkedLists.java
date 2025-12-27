/*
 * Question:
 * How can we find the intersection point of two linked lists?
 * 
 * Explanation:
 * Given two linked lists, we want to find their intersection point if they intersect.
 * We can solve this problem by traversing one linked list and comparing each node with all nodes of the other linked list.
 * If we find a node that is common in both lists, it means they intersect at that node.
 * 
 * Algorithm Steps:
 * 1. Traverse the second linked list and for each node:
 *    a. Traverse the first linked list and for each node:
 *       i. If the current node of the first linked list is the same as the current node of the second linked list, 
 *          return the data value of that node.
 * 2. If no intersection point is found, return -1.
 * 
 * Example:
 * For the given linked lists:
 * List1: 10 -> 15 -> 30 -> null
 * List2: 3 -> 6 -> 9 -> 15 -> 30 -> null
 * The intersection point is 15.
 * 
 * Time Complexity: O(N * M) - Where N is the length of the first linked list and M is the length of the second linked list.
 * Space Complexity: O(1) - Constant space is used.
 */

package LinkedList;

public class IntersectionOfTwoLinkedLists {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to print the linked list
    public void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Function to find the intersection point of two linked lists
    public int getIntersectionNode(Node head1, Node head2) {
        while (head2 != null) {
            Node temp = head1;
            while (temp != null) {
                if (temp == head2) { // Check if nodes are the same
                    return head2.data; // Return the data value of the intersection point
                }
                temp = temp.next; // Move to the next node in the first linked list
            }
            head2 = head2.next; // Move to the next node in the second linked list
        }
        return -1; // No intersection point found
    }
    
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists list = new IntersectionOfTwoLinkedLists();
        Node head1, head2;
        head1 = new Node(10);
        head2 = new Node(3);
        Node newNode = new Node(6);
        head2.next = newNode; newNode = new Node(9);
        head2.next.next = newNode;
        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;
        newNode = new Node(30);
        head1.next.next = newNode; head1.next.next.next = null;
        list.print(head1);
        list.print(head2);
        int intersectionPoint = list.getIntersectionNode(head1, head2);
        System.out.println("Intersection Point: " + intersectionPoint);
    }
}