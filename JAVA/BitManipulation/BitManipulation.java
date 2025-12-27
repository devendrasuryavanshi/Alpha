package BitManipulation;

import java.util.*;

public class BitManipulation {
    // odd or even using bit operations
    public static void oddOrEven(int n) {
        int bitMask = 1;
        if((n & bitMask) == 0) {
            // even
            System.out.println("Even number");
        } else {
            // odd
            System.out.println("Odd number");
        }
    }

    //Get ith bit (OWN)
    public static void getIthBit(int n, int i) {
        int bitMask = 1;
        int ithBit = (n>>i) & bitMask;
        System.out.println(ithBit);
    }
    
    //Get ith bit (DIDI)
    public static int getIthBit2(int n, int i) {
        int bitMask = 1<<i;
        if((n & bitMask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    //set ith bit(OWN)
    public static int setIthBit(int n, int i) {
        int bitMask = 1<<i;
        int setIthBit = n | bitMask;
        return setIthBit;
    }

    //clear ith bit(DIDI)
    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1<<i);
        int clearIthBit = n & bitMask;
        return clearIthBit;
    }

    //update ith bit(IDID)
    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0) {
        //     return clearIthBit(n, i);
        // } else {
        //     return setIthBit(n, i);
        // }

        //another approch
        int bitMask = newBit<<i;
        n = clearIthBit(n, i);
        return n | bitMask;
    }

    //update last i digits(DIDI)
    public static int clearLastIbits(int n, int i) {
        int bitMask = (~0)<<i;// or -> -1<<i
        return n & bitMask;
    }

    //clear range of bits(DIDI)
    public static int clearBitsInRange(int n, int i, int j) {
        int a = ((~0) << j+1);
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;
    }

    //check if a number is a power of 2.
    public static boolean isPowerOfTwo(int n) {
        return (n & (n+1)) == 0;
    }

    //What is the value of x^x for any valueof x?
    //ans: always be 0, because XOR return 0 if both bits are same ...

    //Swap two numbers without using any third variable.
    public static void swapWithoutTemp(int a, int b) {
        System.out.println("old a = "+a+" b = "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("new a = "+a+" b = "+b);
    }

    //Add 1 to an integer using Bit Manipulation
    public static int addOneUsingBit(int n) {
        return -(~n); // n = 4; ~n = -(n+1); ~n = -5; then -(~n) == 5; 
    }

    public static void uppercaseToLowercase() {
        // Convert uppercase character to lowercase
        for(char ch='A';ch<='Z';ch++) {
            System.out.println((char)(ch|' '));
            // prints abcdefghijklmnopqrstuvwxyz
        }
    }

    //print even word count Char ex= Hey: odd(3 letters), Room: even(4 letters)
    public static void printEvenWords(String str) {
        int count = 0;
        for(int i=0; i<str.length(); i++) {
            while (i < str.length() && str.charAt(i) != ' ') {
                count++;
                i++;
            }
            if(count != 0 && count%2 == 0) {
                for(int j=i-count; j<i; j++) {
                    System.out.print(str.charAt(j));
                }
                System.out.print(" ");
            }
            count = 0;
        }
    }

    public static long PowMod(long x, long n, long m)
    {
        long ans = 1;
        
        while(n > 0) {
            if((n&1) != 0) {
                ans = ans * x;
            }
            x = x * x;
            n = n>>1;
        }

        while (m > 0) {
            long res = m;
            if((m&1) != 0) {
                res = (ans+1) / res;
            }
            ans = (ans+1)/res;
            m = m>>1;
        }
        return ans;
    }

    public static int minBitFlips(int start, int goal) {
        int count = 0;
        while(start > 0 || goal > 0) {
            if((start&1) != (goal&1)) {
                count++;
            }
            start = start>>1;
            goal = goal>>1;
        }
        return count;
    }

    public static int singleNumber(int nums[]) {
        Arrays.sort(nums);
        if(nums.length > 1) {
            if(nums[0] != nums[1]) {
                return nums[0];
            }
    
            for(int i=1; i<nums.length-1; i++) {
                if(nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                    return nums[i];
                }
            }

            if(nums[nums.length-1] != nums[nums.length-2]) {
                return nums[nums.length-1];
            }
        }
            return nums[0];
    }

    public static int binaryGap(int n) {
        while ((n&1) == 0) {
            n = n>>1;
        }
        if(n <= 1) {
            return 0;
        }
        int c = 2;
        while (n > 1) {
            if((n&2) == 0) {
                c++;
            } else if((n&1) != 1) {
                c--;
            }
            n = n>>1;
        }
        return c;
    }

    public static void main(String[] args) {
        // oddOrEven(20);
        // getIthBit(10, 2);
        // System.out.println(getIthBit2(10, 2));
        // setIthBit(10, 2);
        // clearIthBit(10, 1);
        // System.out.println(isPowerOfTwo(15));
        // swapWithoutTemp(234, 836);

        int x=-4;
        // System.out.println(x+" + "+1+" is "+-x+" "+(~x));
        // uppercaseToLowercase();
        // printEvenWords("Hello bhai kesa he ree tu yar champion ho tum to coding ke");
        // System.out.println(5/3);
        // System.out.println(PowMod(282538755, 244836246, 757161423));
        // System.out.println(minBitFlips(10, 7));
        int nums[] = {7,6,6,4,2,2,4,6,7,8,8,4,1, 9, 9};
        int n = 1024;
        System.out.println(binaryGap(3));

        System.out.println();
    }
}
