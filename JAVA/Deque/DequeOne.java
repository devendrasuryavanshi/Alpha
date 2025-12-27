package Deque;
import java.util.*;

public class DequeOne {

    //Stack using deque
    static class Stack {
        Deque<Integer> dq = new ArrayDeque<>();

        //push
        public void push(int data) {
            dq.addLast(data);
        }

        //pop
        public int pop() {
            if(dq.isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            return dq.removeLast();
        }

        //peek
        public int peek() {
            if(dq.isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }

            return dq.getLast();
        }
    }
    
    //Queue using deque
    static class Queue {
        Deque<Integer> dq = new ArrayDeque<>();

        //add
        public void add(int data) {
            dq.addLast(data);
        }

        //remove
        public int remove() {
            if(dq.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return dq.removeFirst();
        }

        //peek
        public int peek() {
            if(dq.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);//1
        dq.addFirst(2);//2 1
        dq.addLast(3);//2 1 3
        dq.addLast(4);//2 1 3 4
        dq.removeFirst();//2
        dq.removeLast();//4
        System.out.println(dq);//1 3
        System.out.println(dq.getFirst());
        System.out.println(dq.getLast());

        // Stack s = new Stack();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        // Queue q = new Queue();
        // q.add(1);
        // q.add(2);
        // q.add(3);
        // System.out.println(q.remove());
        // System.out.println(q.remove());
        // System.out.println(q.get());

    }
}
