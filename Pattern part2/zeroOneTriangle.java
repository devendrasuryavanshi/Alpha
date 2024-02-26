/*
q. 0 1 Triangle
1
0 1
1 0 1
0 1 0 1
1 0 1 0 1*/

public class zeroOneTriangle {
    public static void zero_One_Triangle(int n) {
        //row
        for(int i=1; i<=n; i++) {
            //columns
            for(int j=1; j<=i; j++) {
                if((i+j)%2==0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        zero_One_Triangle(5);
    }
}
