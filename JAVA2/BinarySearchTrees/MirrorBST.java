package BinarySearchTrees;

public class MirrorBST {
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
    
    public static void mirrorBST(Node root) {
        if(root == null) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorBST(root.left);
        mirrorBST(root.right);
    }
    
    public static void main(String[] args) {
        int value[] = {8, 5, 3, 6, 10, 11};
        Node root = null;

        for(int i=0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        preOrder(root);
        mirrorBST(root);
        System.out.println();
        preOrder(root);
    }
}
