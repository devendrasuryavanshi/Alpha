package BitManipulation;

public class FastExponentiation {
    public static int fastExpo(int a, int n) {
        int ans = 1;

        while (n > 0) {
            if((n & 1) != 0) { //check LSB
                ans = ans * a;
                System.out.println(ans);
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(fastExpo(4, 4));
    }
}
