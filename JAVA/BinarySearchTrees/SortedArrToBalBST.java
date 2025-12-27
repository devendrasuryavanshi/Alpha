package BinarySearchTrees;
import java.util.*;

public class SortedArrToBalBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(root.data > val) {
            //left subtree
            root.left = insert(root.left, val);
        } else {
            //right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    // convert sorted array to balanced BST
    public static Node sortedArrToBalBST(int arr[], int st, int end) {// O(n)
        if(st > end) {
            return null;
        }

        int mid = (st + end ) / 2;
        Node root = new Node(arr[mid]);
        root.left = sortedArrToBalBST(arr, st, mid-1);
        root.right = sortedArrToBalBST(arr, mid+1, end);

        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if(root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }

    //convert BST to balanced BST
    public static Node balancedBST(Node root) {// O(n)
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorde -> balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        int value[] = {3, 5, 6, 8, 10, 11, 12};

        /*          8
                  /   \
                 5    11
                / \   / \
               3  6  10 12

            exprected BST
        */

        // Node root = sortedArrToBalBST(value, 0, value.length-1);
        // preOrder(root);

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBST(root);
        
        preOrder(root);
    }
}
