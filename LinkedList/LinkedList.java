package LinkedList;

public class LinkedList {

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

    public void addFirst(int data) {
        // step 1 - create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 - newNode next = head
        newNode.next = head; // link

        // step 3 - head = newNode
        head = newNode;
    }

    public void addLast(int data) {
        // step 1 - create new node
        Node newNode = new Node(data);
        size++;
        if(head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 - tail.next = newNode
        tail.next = newNode;

        // step 3 - tail = newNode
        tail = newNode;
        
    }

    public void print() { // O(n)
        if(head == null) {
            System.out.print("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void add(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < index-1) {
            temp = temp.next;
            i++;
        }
        // temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // prev : i = size-2
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    
    public int linearSearch(int key) {// O(n)
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if(temp.data == key) {// key found
                return i;
            }
            temp = temp.next;
            i++;
        }
        // key not found
        return -1;
    }

    public int helper(Node head,int key) {// O(n)
        //base case
        if(head == null) {
            return -1;
        }

        if(head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1) {
            return -1;
        }

        return idx+1;
    }
    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() { // Reverses the linked list
        Node prev = null; // Initialize a reference to the previous node, starts as null
        Node curr = head; // Initialize a reference to the current node, starts from the head of the list
        Node next; // Initialize a reference to the next node
    
        // Traverse the list
        while (curr != null) { // While there are still nodes to process
            next = curr.next; // Store the reference to the next node
            curr.next = prev; // Make the current node point to the previous node, reversing the link
            prev = curr; // Move the prev pointer forward to the current node
            curr = next; // Move the current pointer forward to the next node
        }
    
        head = prev; // Set the head of the list to the last node, which is now the first node after reversal
    }
    
    // find and remove Nth Node from end;
    // AMAZON, Qualcomm etc.
    public int findAndRemNthNodeFromEnd(int n) {
        //calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next; // remove first
            return head.data;
        }
        //sz-n
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        int del = prev.next.data;
        prev.next = prev.next.next;
        return del;
    }

    // Slow-fast approach to find the middle of the linked list
    public Node findMid(Node head) {
        Node slow = head; // Slow pointer starts from the head
        Node fast = head; // Fast pointer also starts from the head

        // Move the pointers until the fast pointer reaches the end or null
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
        }

        return slow; // Return the middle node
    }

    // Check if the linked list is a palindrome
    public boolean checkPalindrome() {
        // Check if the list is empty or has only one node
        if(head == null || head.next == null) {
            return true; // It is a palindrome
        }

        // Step 1: Find the middle node of the list
        Node midNode = findMid(head);

        // Step 2: Reverse the second half of the list
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // Right half of the list is reversed
        Node left = head; // Left half of the list

        // Step 3: Check if the left half and right half of the list are equal
        while (right != null) {
            if(left.data != right.data) {
                return false; // Not a palindrome
            }
            left = left.next;
            right = right.next;
        }

        return true; // It is a palindrome
    }

    public static boolean isCycle() {//floyd's dycle finding algorithm
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
            if(slow == fast) {
                return true;// cycle exists
            }
        }

        return false;// cycle doesn't exists
    }

    public static void removeCycle() {
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle = false) {
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null;// last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> last.next = null
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head; // Initialize slow pointer at the head
        Node fast = head.next; // Initialize fast pointer at the next node of the head
        while (fast != null && fast.next != null) { // Traverse until fast reaches the end or null
            slow = slow.next; // Move slow one step forward
            fast = fast.next.next; // Move fast two steps forward
        }
        return slow; // Return the mid node
    }
    
    private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1); // Create a dummy node for the merged list
        Node temp = mergedLL; // Initialize temp pointer to the dummy node
        while (head1 != null && head2 != null) { // While both lists have elements
            if (head1.data <= head2.data) { // Compare elements of both lists
                temp.next = head1; // Connect temp to the smaller element
                head1 = head1.next; // Move head1 forward
            } else {
                temp.next = head2; // Connect temp to the smaller element
                head2 = head2.next; // Move head2 forward
            }
            temp = temp.next; // Move temp forward
        }
        // Attach remaining elements of list1
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        // Attach remaining elements of list2
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next; // Return the merged list
    }
    
    // Merge sort on linked list
    public Node mergeSort(Node head) { // Time complexity: O(n log n)
        // Base case: If the list is empty or has only one element, return it
        if (head == null || head.next == null) {
            return head;
        }
    
        // Find the mid point of the list
        Node mid = getMid(head);
    
        // Divide the list into two halves
        Node rightHead = mid.next; // Head of the second half
        mid.next = null; // Disconnect the two halves
    
        // Recursively sort the left and right halves
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
    
        // Merge the sorted halves
        return merge(newLeft, newRight);
    }
    
    public Node getPrevLast(Node currPos) {
        Node temp = head;
        if(temp.next == null) {
            return temp;
        }
        while (temp.next.next != null) {
            temp = temp.next;
        }
        return temp;
    }
    //Zig-Zig Linked List
    public void zigZag() {
        Node temp = head;
        while (temp != null && temp.next != null && temp.next.next != null) {
            Node prev = getPrevLast(temp);
            Node next = temp.next;
            temp.next = prev.next;
            temp = temp.next;
            temp.next = next;
            prev.next = null;
            temp = temp.next;
        }
    }
    
    public void zigZagOpt() {
        //find mid
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        
        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //alt merge - zig-zag merge
        Node left = head;
        Node right = prev;
        Node nextL, nextR;
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
            //update
            left = nextL;
            right = nextR;
        }
        
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        for(int i=1; i<=1; i++) {
            ll.addFirst(i);
        }
        // ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.zigZagOpt();
        ll.print();
    }
}
