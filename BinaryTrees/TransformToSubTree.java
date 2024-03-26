package BinaryTrees;

public class TransformToSubTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int idx = -1;

    public static Node buildTree(int nodes[]) {
        idx++; //index

        if(nodes[idx] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[idx]);   

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static int transformToSubTree(Node root) {// O(n)
        if(root == null) {
            return 0;
        }

        int leftSum = transformToSubTree(root.left);
        int rightSum = transformToSubTree(root.right);

        int total = leftSum+rightSum+root.data;
        root.data = leftSum+rightSum;
        
        return total;
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        Node root = TransformToSubTree.buildTree(nodes);
        transformToSubTree(root);
        preorder(root);
    }
    
}
