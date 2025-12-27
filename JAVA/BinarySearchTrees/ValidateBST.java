package BinarySearchTrees;

public class ValidateBST {
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
    
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.data <= min.data) {
            return false;
        }
        if(max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
    
    public static void main(String[] args) {
        int value[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i=0; i < value.length; i++) {
            root = insert(root, value[i]);
        }

        System.out.println(isValidBST(root, null, null));
    }
}
