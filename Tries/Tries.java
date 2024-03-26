package Tries;

public class Tries {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        public Node () {
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {// O(L)
        Node curr = root;
        for(int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        
        curr.eow = true;
    }

    public static boolean search(String key) {
        count++;
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            count++;
            int idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow;
    }

    static int count = 0;
    // Word Break Problem
    public static boolean wordBreak(String key) {
        count++;
        if(key.length() == 0) {
            return true;
        }

        for(int i=1; i<=key.length(); i++) {
            count++;
            if(search(key.substring(0, i)) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    // Word Break Problem (OWN)
    public static boolean wordBreakOwn(String key) {
        count++;
        Node curr = root;
        int idx = key.charAt(0) - 'a';
        if(key.length() == 0) {
            return true;
        } else if(curr.children[idx] == null) {
            return false;
        }
        curr = curr.children[idx];
        for(int i=1; i<key.length(); i++) {
            count++;
            idx = key.charAt(i) - 'a';
            if(curr.children[idx] == null) {
                return wordBreakOwn(key.substring(i));
            }
            curr = curr.children[idx];
        }

        return curr.eow;
    }
    
    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};

        // for(int i=0; i<words.length; i++) {
        //     insert(words[i]);
        // }
        // String key = "thar";
        // System.out.println(search(key));

        String words2[] = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for(int i=0; i<words2.length; i++) {
            insert(words2[i]);
        }

        String key = "ilikesamsung";
        count = 0;
        System.out.println("DID = "+wordBreak(key) +" "+ count);
        count = 0;
        System.out.println("OWN = "+wordBreakOwn(key) +" "+ count);
    }
}
