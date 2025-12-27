package BinaryTrees;
import java.util.*;

import javax.management.Query;

public class KthLevel {
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

    //Recursive approach
    public static void kthLevel(Node root, int k, int level) {// O(n)
        if(root == null) {
            return;
        }

        if(level == k) {
            System.out.print(root.data+" ");
        }

        kthLevel(root.left, k, level+1);
        kthLevel(root.right, k, level+1);
    }

    public static void kthLevel2(Node root, int k) {
        if(root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int level = 1;
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(currNode.left != null) {
                    q.add(currNode.left);
                }

                if(currNode.right != null) {
                    q.add(currNode.right);
                }
                level++;
            }

            if(level-1 == k) {
                while (!q.isEmpty()) {
                    if(q.peek() != null) {
                        System.out.print(q.remove().data+" ");
                    } else {
                        q.remove();
                    }
                }
            }
        }
    }

    
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        Node root = KthLevel.buildTree(nodes);
        int k = 2;
        // kthLevel(root, k, 1);
        kthLevel2(root, k);
    }
}
