package ArrayList;

import java.util.ArrayList;

public class MostFrequentNumberfollowingKey {
    public static int mostFrequentNumberfollowingKey(ArrayList<Integer> nums, int key) {
        int count[] = new int[1001];
        int maxCount = 0;

        for(int i=0; i<nums.size()-1; i++) {
            if(nums.get(i) == key) {
                count[nums.get(i+1)]++;
                if(count[maxCount] < count[nums.get(i+1)]) {
                    maxCount = nums.get(i+1);
                }
            }
        }
        return maxCount;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(2);
        nums.add(3);

        System.out.println(mostFrequentNumberfollowingKey(nums, 2));
    }
}
