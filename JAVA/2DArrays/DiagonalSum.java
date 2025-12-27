public class DiagonalSum {

    public static int diagonalSum(int matrix[][], int n) {
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += matrix[i][i];
            sum += matrix[i][n-i-1];
        }

        //remove extra calculated value
        if(n%2!=0) {
            sum -= matrix[n/2][n/2];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int matrix[][] = new int[4][4];
        int n = matrix.length;
        int count = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = count++;
                System.out.print(matrix[i][j]+" ");
            }
        }
        System.out.println(diagonalSum(matrix, n));
    }
}
