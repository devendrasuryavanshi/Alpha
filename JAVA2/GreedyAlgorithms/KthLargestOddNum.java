package GreedyAlgorithms;

public class KthLargestOddNum {

    //OWN
    public static int kthLargestOdd(int l, int r, int k) {
        if(r%2 == 0) {
            r--;
        }

        int res = r-((k*2) - 2);
        if(res >= l && res <= r) {
            return res;
        }

        return 0;
    }

    //INTERNET
    public static int kthOdd(int L, int R, int K) {
        if (K <= 0) return 0;

        if ((R & 1) > 0) {
            int Count = (int) Math.ceil((R - L + 1) / 2);

            if (K > Count) {
                return 0;
            } else {
                return (R - 2 * K + 2);
            }
        } else {
            int Count = (R - L + 1) / 2;

            if (K > Count) {
                return 0;
            } else {
                return (R - 2 * K + 1);
            }
        }
    }

    public static void main(String[] args) {
        int k = 4;
        System.out.println(kthLargestOdd(-3, 3, k));
        System.out.println(kthOdd(-3, 3, k));
        char a = 'z';
        char b = 'a';
        System.out.println(a-b);
    }
}
