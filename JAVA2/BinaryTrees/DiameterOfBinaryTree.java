package BinaryTrees;
import BinaryTrees.BinaryTreeA.*;

public class DiameterOfBinaryTree {

    static class info {
        int height;
        int diameter;

        public info(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }
    
    public static int diameter(Node root) {// O(n^2)
        if(root == null) {
            return 0;
        }

        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        int leftHeight = tree.height(root.left);
        int rightHeight = tree.height(root.right);

        int selfDia = leftHeight + rightHeight + 1;

        return Math.max(Math.max(leftDia, rightDia), selfDia);
    }

    public static info diameterOpt(Node root) {// O(n)
        if(root == null) {
            return new info(0, 0);
        }

        info leftInfo = diameterOpt(root.left);
        info rightInfo = diameterOpt(root.right);

        int dia = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height) + 1;
        int ht = Math.max(leftInfo.height, rightInfo.height) + 1;

        return new info(ht, dia);
    }

    static BinaryTree tree = new BinaryTree();
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = tree.buildTree(nodes);

        
        System.out.println(diameterOpt(root).diameter);
    }
}
