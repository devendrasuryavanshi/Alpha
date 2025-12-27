package Hashing;
import java.util.*;

public class Linkedhashmap {
    
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("US", 50);
        lhm.put("Japan", 5);

        System.out.println(lhm);
    }
}
