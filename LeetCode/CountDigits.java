package LeetCode;

public class CountDigits {

    public static int countDigits(int N) {
        int num = N;
        int count = 0;
        while (N>0) {
            int ld = N%10;
            if(num%ld == 0) {
                count++;
            }
            N /= 10;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int N = 2;
        System.out.println(countDigits(N));
    }
}
