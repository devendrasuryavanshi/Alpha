package BinaryTrees;

public class MinDistanceBtwNodes {
    
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

    public static Node lca(Node root, int n1, int n2) {
        if(root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        if(rightLca == null) {
            return leftLca;
        }

        if(leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        } else if(leftDist == -1) {
            return rightDist+1;
        } else {
            return leftDist+1;
        }
    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;

    }

    //kth ancestor of node
    public static int kthAncestor(Node root, int n, int k) {// O(n)
        if(root == null) {
            return -1;
        }

        if(root.data == n) {
            return 0;
        }

        int leftDist = kthAncestor(root.left, n, k);
        
        int rightDist = -1;
        if(leftDist == -1) {
            rightDist = kthAncestor(root.right, n, k);
        }

        if(leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if(max+1 == k) {
            System.out.println(root.data);
        }

        return max+1;
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        Node root = MinDistanceBtwNodes.buildTree(nodes);
        // int minDist = minDistance(root, 4, 3);
        // System.out.println(minDist);
        kthAncestor(root, 5, 1);
    }
}
