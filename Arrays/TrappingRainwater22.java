package Arrays;

public class TrappingRainwater22 {

    public static int Trapping_Rainwater(int height[]) {
        int n = height.length;
        // index of the maximum value in the array (right max)
        int rightMax = 0;
        // Find the index of the maximum height in the array
        for (int i = 0; i <= n / 2; i++) {
            if (height[i] >= height[rightMax]) {
                rightMax = i;
            }
            if (height[n-i-1] >= height[rightMax]) {
                rightMax = n-i-1;
            }
        }
        // index of height[i]th left max value;
        int leftMax = 0;
        //trapped rainwater = min(leftMax[i], rightMax[i]) - height[i]
        int trappedWater = 0;

        // Calculate trapped water from the left side to the maximum height
        for(int i=0; i<=rightMax; i++) {
            if(i==0 || height[i]==height[rightMax] || height[i]>=height[leftMax]) {
                trappedWater += 0;
                leftMax = i;
            } else {
                trappedWater += height[leftMax] - height[i]; // we know the rightMax is the largest value of array so minimum value always be leftMax
            }
        }

        // Calculate trapped water from the right side (reversed perspective), reversing the array to consider the right max value of the array's max value
        leftMax = n-1;
        for(int i=n-1; i>rightMax; i--) {
            if(i==n-1 || height[i]==height[rightMax] || height[i]>=height[leftMax]) {
                trappedWater += 0;
                leftMax = i;
            } else {
                trappedWater += height[leftMax] - height[i];
            }
        }
        //return trapped water value
        return trappedWater;
    }
    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 2, 3, 5};
        int trappedWater =  Trapping_Rainwater(height);
        System.out.println(trappedWater);
    }
}
