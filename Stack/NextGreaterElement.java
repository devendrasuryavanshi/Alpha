package Stack;

import java.util.Stack;

public class NextGreaterElement {
    
    public static void main(String[] args) {// O(n)
        int arr[] = {6, 8, 0, 1, 3};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--) {
            // while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // if-else
            if(s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            // push in s
            s.push(i);
        }

        for(int i=0; i<nextGreater.length; i++) {
            System.out.print(nextGreater[i]+" ");
        }

        //forms of question
        //next Greater Right
        //next Greater Left
        //next Smaller Right
        //next Smaller LEft
    }
}
