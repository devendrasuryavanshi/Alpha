package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumbers {

    public static ArrayList<Integer> lonelyNumbers(ArrayList<Integer> nums) {
        Collections.sort(nums);
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=1; i<nums.size()-1; i++) {
            if(nums.get(i-1) + 1 < nums.get(i) && nums.get(i) + 1 <nums.get(i+1)) {
                ans.add(nums.get(i));
            }
        }

        if(nums.size() == 1) {
            ans.add(nums.get(0));
        }

        if(nums.size() > 1) {
            // first index
            if(nums.get(0) + 1 < nums.get(1)) {
                ans.add(nums.get(0));
            }
            //last index
            if(nums.get(nums.size()-1) - 1 > nums.get(nums.size()-2)) {
                ans.add(nums.get(nums.size()-1));
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();

        nums.add(10);
        nums.add(6);
        nums.add(5);
        nums.add(8);

        System.out.println(lonelyNumbers(nums));
    }
}
