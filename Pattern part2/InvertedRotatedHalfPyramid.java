/* 
q. Print inverted and rotated half pyramid
      *
    * *
  * * *
* * * *

*/

import java.util.*;

public class InvertedRotatedHalfPyramid {
    public static void Inverted_Rotated_Half_Pyramid(int n) {
        //row 
        for(int i=1; i<=n; i++) {
            //columns
            for(int j=1; j<=n; j++) {
                if(j>n-i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Inverted_Rotated_Half_Pyramid(n);
    }
    
}
