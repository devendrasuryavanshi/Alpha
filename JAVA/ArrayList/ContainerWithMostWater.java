/*
 * Question:
 * How can we find the maximum water that can be trapped between the bars represented by the given heights?
 * 
 * Explanation:
 * The "Two Pointer" approach is used to find the maximum water that can be trapped between two bars in an array.
 * Two pointers, lp (left pointer) and rp (right pointer), start from the two ends of the array and move towards each other.
 * The idea is to calculate the water trapped between the bars at the current positions of lp and rp and maximize it.
 * 
 * Algorithm Steps:
 * 1. Initialize lp and rp at the two ends of the array.
 * 2. While lp is less than rp:
 *    a. Calculate the width between lp and rp.
 *    b. Calculate the water that can be trapped at the current positions of lp and rp.
 *    c. Move the pointer with the smaller height towards the center.
 *    d. Update the maximum water trapped if the current water is greater than the previous maximum.
 * 3. Return the maximum water trapped.
 * 
 * Example:
 * For the input [1, 8, 6, 2, 5, 4, 8, 3, 7], the maximum trapped water is 49.
 * 
 * Time Complexity: O(N) - As both pointers traverse the array once.
 * Space Complexity: O(1) - Constant space is used.
 */


// flipkart
package ArrayList;

import java.util.ArrayList;

public class ContainerWithMostWater {

    //Brute Force Approach
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;

        for(int i=0; i<height.size(); i++) {
            for(int j=i+1; j<height.size(); j++) {
                int minHeight = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int water = width * minHeight;
                maxWater = Math.max(maxWater, water);
            }
        }

        return maxWater;

    }

    //2 Pointer Approach
    public static int storeWater2(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while (lp < rp) {
            int width = rp - lp;
            int currWater;

            if(height.get(lp) < height.get(rp)) {
                currWater = width * height.get(lp);
                lp++;
            } else {
                currWater = width * height.get(rp);
                rp--;
            }
            maxWater = Math.max(maxWater, currWater);
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        //1, 8, 6, 2, 5, 4, 8, 3, 7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater2(height));
    }
}