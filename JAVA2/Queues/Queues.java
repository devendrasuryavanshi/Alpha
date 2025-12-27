package Queues;

import java.util.*;

public class Queues {

    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        //add
        public static void add(int data) {
            if(rear == size-1) {
                System.out.println("queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        //remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int front = arr[0];
            for(int i=0; i<rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return arr[0];
        }
    }
    /*
    static class Queue {
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public static boolean isFull() {
            return (rear+1) % size == front;
        }

        //add
        public static void add(int data) {
            if(isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // add last el
            if(front == -1) {
                front = 0;
            }
            rear = (rear+1) % size;
            arr[rear] = data;
        }

        //remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int result = arr[front];
            if(rear == front) {
                front = rear = -1;
            } else {
                front = (front+1) % size;
            }

            return result;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return arr[0];
        }
    }
     */
    
    //queue using ll
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /*
    static class Queue {
        static Node head = null;
        static Node tail = null;
        
        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        //add
        public static void add(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = tail = newNode;
            }

            tail.next = newNode;
            tail = newNode;
        }

        //remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int front = head.data;
            //single element
            if(head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return head.data;
        }
    }
     */

    // Queue using two stacks
    /*
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //add
        public static void add(int data) {// O(n)
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("queue empty");
                return -1;
            }

            return s1.pop();
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("queue empty");
                return -1;
            }

            return s1.peek();
        }
    }
     */

    /*
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //add
        public static void add(int data) {
            s1.push(data);
        }

        //remove
        public static int remove() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int res = s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return res;
        }

        //peek
        public static int peek() {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int res = s2.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return res;
        }
    }
     */

    // Stack using two queues
    /*
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        //push
        public static void push(int data) {
            if(!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        //pop
        public static int pop() {// O(n)
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int top = -1;
            //case 1
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if(q1.isEmpty()) {
                        break;
                    }

                    q2.add(top);
                }
            } else { //case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if(q2.isEmpty()) {
                        break;
                    }

                    q1.add(top);
                }
            }

            return top;
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int top = -1;
            //case 1
            if(!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);
                }
            } else { //case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }

            return top;
        }

    }
     */

    /*
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        //push
        public static void push(int data) {// O(n)
            if(!q1.isEmpty()) {
                q2.add(data);
                while (!q1.isEmpty()) {
                    q2.add(q1.remove());
                }
            } else {
                q1.add(data);
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
        }

        //pop
        public static int pop() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            if(!q1.isEmpty()) {
                return q1.remove();
            } else {
                return q2.remove();
            }
        }

        //peek
        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            if(!q1.isEmpty()) {
                return q1.peek();
            } else {
                return q2.peek();
            }
        }
    }
     */

    public static void main(String[] args) {
        Queue q = new Queue(6);
        // Queue<Integer> q = new LinkedList<>(); // ArrayDeque

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
        // Queue<Integer> q = new LinkedList<>(); // ArrayDeque
        // Queue q = new Queue();
        // Stack s = new Stack();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }
    }
}
