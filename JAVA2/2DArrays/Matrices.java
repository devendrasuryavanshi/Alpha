import java.util.Scanner;

public class Matrices {

    public static boolean search(int matrix[][], int n, int m, int key) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == key) {
                    System.out.println(key+" found at "+i+", "+j);
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        int n = matrix.length, m = matrix[0].length;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<n; i++) {
            for(int j=0;j<m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        //print
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        search(matrix, n, m, 7);
    }
}
