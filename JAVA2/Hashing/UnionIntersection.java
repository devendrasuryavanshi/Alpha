package Hashing;
import java.util.*;

public class UnionIntersection {
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        // Union
        for(int i=0; i< arr1.length; i++) {
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union = "+set.size()+" "+set);

        //Intersection
        set.clear();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                arr.add(arr2[i]);
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection "+arr.size()+" "+arr);
    }
}
