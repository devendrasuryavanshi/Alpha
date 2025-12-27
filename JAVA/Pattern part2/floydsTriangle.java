/*q. Floyd's Triangle Pattern
1
2 3
4 5 6
7 8 9 10
11 12 13 14 15
*/

import java.util.*;

public class floydsTriangle {
    public static void floyds_Triangle(int n) {
        int counter = 1;
        //rows
        for(int i=1; i<=n; i++) {
            //columns
            for(int j=1; j<=i; j++) {
                System.out.print(counter++ +" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        floyds_Triangle(5);
    }
    
}
