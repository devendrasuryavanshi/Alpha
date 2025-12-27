package LeetCode;

import java.util.Arrays;

public class Tower {

    public static int diffLongestBtnShortestTower(int height[], int n, int k) {
        Arrays.sort(height);
        int l = Integer.MIN_VALUE;
        int s = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(k < height[i]) {
                s = Math.min(height[i] - k, s);
                l = Math.max(height[i] - k, l);
            } else {
                s = Math.min(height[i] + k, s);
                l = Math.max(height[i] + k, l);
            }
        }
        
        return l-s;
    }
    
    public static void main(String[] args) {
        int height[] = {3, 9, 12, 16, 20};
        System.out.println(diffLongestBtnShortestTower(height, height.length, 3));
    }
}
