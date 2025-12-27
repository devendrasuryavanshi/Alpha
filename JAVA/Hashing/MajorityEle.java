package Hashing;
import java.util.*;

public class MajorityEle {

    public static String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
    
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    
        // Create a TreeMap sorted by frequency
        TreeMap<Integer, List<Character>> freqMap = new TreeMap<>(Collections.reverseOrder());
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (!freqMap.containsKey(freq)) {
                freqMap.put(freq, new ArrayList<>());
            }
            freqMap.get(freq).add(key);
        }
    
        // Build the sorted string
        StringBuilder sb = new StringBuilder();
        for (int freq : freqMap.keySet()) {
            List<Character> chars = freqMap.get(freq);
            for (char ch : chars) {
                for (int i = 0; i < freq; i++) {
                    sb.append(ch);
                }
            }
        }
    
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int i=0; i<arr.length; i++) {
        //     map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        // }

        // for(Integer key : map.keySet()) {
        //     if(map.get(key) > arr.length/3) {
        //         System.out.println(key);
        //     }
        // }

        System.out.println(frequencySort("tree"));
    }
}
