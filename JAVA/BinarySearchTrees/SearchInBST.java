package BinarySearchTrees;

public class SearchInBST {
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

    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    
    public static boolean search(Node root, int key) {// O(H)
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    public static void main(String[] args) {
        int value[] = {5, 3, 2, 1, 4, 8, 7, 6, 10, 9};
        Node root = null;

        for(int i=0; i < value.length; i++) {
            root = insert(root, value[i]);
        }

        System.out.println(search(root, 5));
    }
}
