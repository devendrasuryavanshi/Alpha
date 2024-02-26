package Stack;
import java.util.Stack;

public class PalindromeLinkedList {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean palindromeLinkedList(Node head) {
        Stack<Character> s = new Stack<>();
        Node temp = head;
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if(temp.data == s.pop()) {
                temp = temp.next;
            } else {
                return false;
            }
        }

        return true;
    }

    public static int trappingRainWater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int ans = 0;
        int max = 0;
        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] >= max) {
                s.push(i);
            }
            max = Math.max(max, arr[i]);
        }

        max = 0;
        for(int i=0; i<arr.length; i++) {
            max = Math.max(max, arr[i]);
            int minVal = Math.min(max, arr[s.peek()]);
            ans += minVal - arr[i];
            if(i == s.peek()) {
                s.pop();
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Node l1 = new Node('A');
        Node l2 = new Node('C');
        Node l3 = new Node('C');
        Node l4 = new Node('C');
        Node l5 = new Node('A');
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        // System.out.println(palindromeLinkedList(l1));
        int arr[] = {7, 0, 4, 2, 5, 0, 6, 4, 0, 5};
        System.out.println(trappingRainWater(arr));
    }
}