package BinaryTrees;

public class SubTreeOfAnotherTree {

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

    static class BinaryTree {
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
    }

    static int count = 0;
    public static boolean isSubTree(Node root1, Node root2) {
        count++;
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null || root2 == null) {
            return false;
        }
        if(root1.data == root2.data) {
            boolean left = isSubTree(root1.left, root2.left);
            if(!left) {
                return false;
            }
            boolean right = isSubTree(root1.right, root2.right);
            if(!right) {
                return false;
            }
            return true;
        }

        boolean l = isSubTree(root1.left, root2);
        boolean r = isSubTree(root1.right, root2);

        return l || r;
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        count++;
        if(root == null && subRoot == null) {
            return true;
        } else if(root == null || subRoot == null || root.data != subRoot.data) {
            return false;
        }

        if(!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if(!isIdentical(root.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubTree2(Node root, Node subRoot) {
        count++;
        if(root == null) {
            return false;
        }

        if(root.data == subRoot.data) {
            if(isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubTree2(root.left, subRoot) || isSubTree2(root.right, subRoot);
    }

    static BinaryTree tree1 = new BinaryTree();
    static BinaryTree tree2 = new BinaryTree();
    public static void main(String[] args) {
        int nodes1[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        int nodes2[] = {2, 4, -1, -1, 5, -1, -1};

        Node root1 = tree1.buildTree(nodes1);
        BinaryTree.idx = -1;
        Node root2 = tree2.buildTree(nodes2);
        System.out.println("My count and ans = "+isSubTree(root1, root2)+" "+count);
        count = 0;
        System.out.println("DIDI count and ans = "+isSubTree2(root1, root2)+" "+count);
    }
}
