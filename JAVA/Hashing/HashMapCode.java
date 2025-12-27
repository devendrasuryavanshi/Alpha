package Hashing;
import java.util.*;

public class HashMapCode {
    
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // LinkedList size
        private int N;
        private LinkedList<Node> buckets[]; // N - buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if(node.key == key) {
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void reHash() {
            LinkedList<Node> oldBucket[] = buckets;
            N *= 2;
            buckets = new LinkedList[N];

            for(int i=0; i<N; i++) {
                buckets[i] = new LinkedList<>();
            }

            // nodes -> add in bucket
            for(int i=0; i<oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        // put
        public void put(K key, V value) {// O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda > 2.0) {
                reHash();
            }
        }

        // containsKey
        public boolean containsKey(K key) {// O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                return true;
            } else {
                return false;
            }
        }

        // get
        public V get(K key) {// O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        // remove
        public V remove(K key) {// O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        // keySet
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<N; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        // isEmpty
        public boolean isEmpty() {
            return n == 0;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Japan", 5);

        ArrayList<String> keys = hm.keySet();

        for (String key : keys) {
            System.out.println(key+" = "+hm.get(key));
        }

        System.out.println(hm.remove("Japan"));
        System.out.println(hm.get("japan"));
    }
}