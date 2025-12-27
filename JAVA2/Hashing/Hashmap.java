package Hashing;

import java.util.*;

public class Hashmap {
    
    public static void main(String[] args) {
        // Create
        HashMap<String, Integer> hm = new HashMap<>();

        // Insert - O(1)
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);

        System.out.println(hm);

        // Get - O(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Japan"));// Null

        // ContainsKey - O(1)
        System.out.println(hm.containsKey("US"));// true
        System.out.println(hm.containsKey("Japan"));// false

        //Remove - O(1)
        System.out.println(hm.remove("China"));
        System.out.println(hm.remove("Japan"));// Null
        System.err.println(hm);

        //------------------------------------//

        HashMap<String, Integer> hm2 = new HashMap<>();

        hm2.put("India", 100);
        hm2.put("US", 50);
        hm2.put("China", 150);
        hm2.put("Japan", 20);
        hm2.put("Nepal", 8);

        Set<String> keys = hm2.keySet();

        for (String k : keys) {
            System.out.println("Key = " + k + ", Value = " + hm2.get(k));
        }
    }
}
