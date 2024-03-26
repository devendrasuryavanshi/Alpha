package Tries;

public class StartWith {
    static class Node {
        Node[] childern = new Node[26];
        boolean eow = false;

        public Node() {
            for(int i=0; i<26; i++) {
                childern[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            }

            curr = curr.childern[idx];
        }

        curr.eow = true;
    }

    // Start With Prefix
    public static boolean startWith(String prefix) {
        Node curr = root;

        for(int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(curr.childern[idx] == null) {
                return false;
            }
            curr = curr.childern[idx];
        }

        return true;
    }
    
    public static void main(String[] args) {// O(L)
        String words[] = {"apple", "app", "mango", "man", "woman"};

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        String prefix1 = "app";
        String prefix2 = "moon";
        String prefix3 = "wom";

        System.out.println(startWith(prefix3));
    }
}
