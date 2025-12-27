// q. Print Hollow Rectangle Pattern

// * * * * *
// *       *
// *       *
// * * * * *

import java.util.*;

public class hollowRectangle{
    public static void hollow_Rectangle(int n) {
        //Rows loop
        for(int i=1; i<=n; i++) {
            //Columns loop
            for(int j=1; j<=n; j++) {
                if(i==1 || i==n || j==1 || j==n) {
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
        hollow_Rectangle(n);
    }
}