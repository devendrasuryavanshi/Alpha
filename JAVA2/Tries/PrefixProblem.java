package Tries;

public class PrefixProblem {
    static class Node {
        Node[] childern = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(int i=0; i<26; i++) {
                childern[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if(curr.childern[idx] == null) {
                curr.childern[idx] = new Node();
            } else {
                curr.childern[idx].freq++;
            }

            curr = curr.childern[idx];
        }

        curr.eow = true;
    }
    static int count = 0;

    // Find Prefix
    public static void findPrefix(Node root, String ans) {
        count++;
        if(root == null) {
            return;
        }

        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for(int i=0; i<root.childern.length; i++) {
            count++;
            if(root.childern[i] != null) {
                findPrefix(root.childern[i], ans+(char)(i+'a'));
            }
        }
    }

    // Find Prefix (OWN) Opt
    public static void findPrefix2(String words[], int idx) {
        count++;
        if(idx == words.length) {
            return;
        }
        Node curr = root;
        String word = words[idx];
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<word.length(); i++) {
            count++;
            int index = word.charAt(i) - 'a';
            ans.append(word.charAt(i));

            if(curr.childern[index].freq == 1) {
                System.out.println(ans);
                break;
            }

            curr = curr.childern[index];
        }

        findPrefix2(words, ++idx);

        return;
    }
    
    public static void main(String[] args) {
        String words[] = {"zebra", "dog", "duck", "dove"};

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        root.freq = -1;
        count = 0;
        findPrefix(root, "");
        System.out.println("Count = "+count);

        count = 0;
        findPrefix2(words, 0);
        System.out.println("Count = "+count);
    }
}
