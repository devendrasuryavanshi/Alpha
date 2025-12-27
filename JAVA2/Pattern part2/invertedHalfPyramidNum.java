/*
q. Inverted half pyramid pattern with number
1 2 3 4 5
1 2 3 4
1 2 3
1 2
1
*/

import java.util.*;

public class invertedHalfPyramidNum {
    public static void inverted_Half_Pyramid_Num(int n) {
        //rows
        for(int i=1; i<=n; i++) {
            //columns
            for(int j=1; j<=n-i+1; j++) {
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        inverted_Half_Pyramid_Num(n);
    }
    
}