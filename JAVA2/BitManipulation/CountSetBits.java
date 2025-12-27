package BitManipulation;

// GOOGLE
// AMAZON

//Time and Space Complexity:
  // Time Complexity: O(log n)+1; explanation: log₂(8) = 3, because 2^3 = 8 (What is the exponent of 2 needed to get 8? It's 3 because 2 ^ 3 = 8.)
  //Space = O(1)

public class CountSetBits {
    public static int countSetBits(int n) {
        int count = 0;
        while (n>0) {
            if((n&1) == 1) { //check our LSB
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSetBits(63));
    }
}
