package codeforces;

import java.util.Scanner;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tt = sc.nextInt();
        while (tt-- > 0) {
            String s = sc.next();
            int i = 0, j = s.length() - 1;

            boolean isPalindrome = true;

            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    isPalindrome = false;
                    break;
                } else {
                    i++;
                    j--;
                }
            }
            System.out.println(isPalindrome ? "YES" : "NO");
        }
    }
}
