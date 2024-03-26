package Hashing;
import java.util.*;

public class Hashset {
    
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(4);
        set.add(2);
        set.add(1);

        System.out.println(set); // [1, 2, 4]

        Iterator it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // LinkedHashSet
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        lhs.add("Indore");
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Pune");

        System.out.println(lhs);

        // TreeSet
        TreeSet<String> ts = new TreeSet<>();

        ts.add("Indore");
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("Pune");

        System.out.println(ts);
    }
}
