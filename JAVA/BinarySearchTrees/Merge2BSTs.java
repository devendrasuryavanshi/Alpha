package BinarySearchTrees;

import java.util.*;

public class Merge2BSTs {
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

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    public static Node createBST(ArrayList<Integer> arr, int st, int end) {
        if(st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);

        return root;
    }

    public static Node merge(Node root1, Node root2) {// O(n+m)
        // step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        getInorder(root1, arr1);
        getInorder(root2, arr2);

        //step 2
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (!arr1.isEmpty() && !arr2.isEmpty()) {
            if(arr1.get(0) <= arr2.get(0)) {
                finalArr.add(arr1.remove(0));
            } else {
                finalArr.add(arr2.remove(0));
            }
        }

        while (!arr1.isEmpty()) {
            finalArr.add(arr1.remove(0));
        }

        while (!arr2.isEmpty()) {
            finalArr.add(arr2.remove(0));
        }

        // sorted AL - balanced BST
        return createBST(finalArr, 0, finalArr.size()-1);
    }

    public static void main(String[] args) { // O(n+m) -> linear
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = merge(root1, root2);

        preOrder(root);
    }
}
