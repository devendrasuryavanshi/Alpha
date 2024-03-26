package BinaryTrees;
import java.util.*;

public class TopOfTree {
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

    static int min = 1, max = -1;
    static HashMap<Integer, Node> map = new HashMap<>();
    public static void topView(Node root, int x) {
        if(root == null) {
            return;
        }

        if(x < min && x > max) {
            min--;
            max++;
            map.put(x, root);
        }

        if(x > max) {
            max++;
            map.put(x, root);
        } else if(x < min) {
            min--;
            map.put(x, root);
        }

        topView(root.left, x-1);
        topView(root.right, x+1);
    }

    static class Info {
        Node node;
        int hd; //horizontal space

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView2(Node root) {
        //level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
    
                if(curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
    
                if(curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            System.out.print(map.get(i).data+" ");
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        topView2(root);
        // for(int i=min; i<=max; i++) {
        //     System.out.print(map.get(i).data+" ");
        // }
    }
}
