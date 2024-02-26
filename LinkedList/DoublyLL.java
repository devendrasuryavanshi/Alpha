package LinkedList;

public class DoublyLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    //remove first
    public int removeFirst() {
        if(head == null) {
            System.err.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //remove last
    public int removeLast() {
        if(head == null) {
            System.err.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        if(size == 1) {
            size--;
            int val = head.data;
            head = tail = null;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    //print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    //reverse a doubly LL
    // public void reverse() {
    //     Node left = head, right = tail;
    //     while (left != right && left.prev != right) {
    //         int temp = left.data;
    //         left.data = right.data;
    //         right.data = temp;
    //         left = left.next;
    //         right = right.prev;
    //     }
    // }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        // dll.addFirst(0);
        dll.print();
        dll.reverse();
        dll.print();
    }
}
