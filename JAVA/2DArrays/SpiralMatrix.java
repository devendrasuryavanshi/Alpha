import java.util.ArrayList;

public class SpiralMatrix {

    public static ArrayList<Integer> printSpiral(int matrix[][], int n, int m) {
        // int sR = 0, eR = n-1;
        // int sC = 0, eC = m-1;
        // while (sR<=eR && sC<=eC) {
        //     //top boundry
        //     for(int i=sC; i<=eC; i++) {
        //         System.out.print(matrix[sR][i]+" ");
        //     }
        //     sR++;

        //     //right boundry
        //     for(int i=sR; i<=eR; i++) {
        //         System.out.print(matrix[i][eC]+" ");
        //     }
        //     eC--;

        //     //bottom boundry
        //     for(int i=eC; i>=sC; i--) {
        //         if(sR-1==eR) {
        //             break;
        //         }
        //         System.out.print(matrix[eR][i]+" ");
        //     }
        //     eR--;

        //     //left boundry
        //     for(int i=eR; i>=sR; i--) {
        //         if(sC==eC+1) {
        //             break;
        //         }
        //         System.out.print(matrix[i][sC]+" ");
        //     }
        //     sC++;
        // }

        int sR = 0, eR = n-1;
        int sC = 0, eC = m-1;
        int spiral[] = new int[n*m];
        int c = 0;
        while (sR<=eR && sC<=eC) {
            //top boundry
            for(int i=sC; i<=eC; i++) {
                spiral[c++] = matrix[sR][i];
            }
            sR++;

            //right boundry
            for(int i=sR; i<=eR; i++) {
                spiral[c++] = matrix[i][eC];
            }
            eC--;

            //bottom boundry
            for(int i=eC; i>=sC; i--) {
                if(sR-1==eR) {
                    break;
                }
                spiral[c++] = matrix[eR][i];
            }
            eR--;

            //left boundry
            for(int i=eR; i>=sR; i--) {
                if(sC==eC+1) {
                    break;
                }
                spiral[c++] = matrix[i][sC];
            }
            sC++;
        }
        ArrayList<Integer> result = new ArrayList<>();
    for (int value : spiral) {
        result.add(value);
    }
    return result;
    }
    public static void main(String[] args) {
        int matrix[][] = new int[4][2];
        int n = matrix.length, m = matrix[0].length;
        int count = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j] = count++;
                // System.out.print(matrix[i][j]+" ");
            }
        }
        printSpiral(matrix, n, m);
    }
}
