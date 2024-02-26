package ArrayList;

import java.util.ArrayList;

public class MonotonicArrayList {

    private static boolean monotonicArrayList(ArrayList<Integer> nums) {
        int n = nums.size();
        boolean inc = true;
        boolean dec = true;

        for(int i=0; i<nums.size()-1; i++) {
            //ascending
            if(nums.get(i) > nums.get(i+1)) {
                inc = false;
            }
            //descending
            if(nums.get(i) < nums.get(i+1)) {
                dec = false;
            }
        }

        return inc || dec;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(2);
        // nums.add(4);

        System.out.println(monotonicArrayList(nums));
    }
}
