public class BinarySearchMatrix {
    
    public static boolean searchInSortedMatrix(int matrix[][], int key) {
        int n = matrix.length, m = matrix[0].length;
        int rowPos = 0, colPos = m-1;
        //check for key is it exist within array
        if(key < matrix[0][0] || key > matrix[n-1][m-1]) {
            System.out.println(key+" does not exist");
            return false;
        }
        while (rowPos < n && colPos >= 0) {
            if(matrix[rowPos][colPos] == key) {
                System.out.println(key+" found at row/col "+rowPos+", "+colPos);
                return true;
            } else if(matrix[rowPos][colPos] > key) {
                colPos -= 1;
            } else {
                rowPos += 1;
            }
        }
        System.out.println(key+" is not found");
        return false;
    }
    

    public static boolean binarySearchMatrix(int matrix[][], int key) {
        int n = matrix.length, m = matrix[0].length;
        int rowStart = -1, colStart = -1;
        int rowEnd = -1, colEnd = -1;
        int rowMid = 0, colMid = 0;
        int currRow = -1, currCol = -1;
        //check for key is it exist within array
        if(key < matrix[0][0] || key > matrix[n-1][m-1]) {
            System.out.println(key+" does not exist");
            return false;
        }

        //rows
        if(key >= matrix[0][0] && key <= matrix[n-1][0]) {
            rowStart = 0;
            rowEnd = n-1;
            currRow = 0;
        } else if(key >= matrix[0][m-1] && key <= matrix[n-1][m-1]) {
            rowStart = 0;
            rowEnd = n-1;
            currRow = m-1;
        } else {

        }

        //columns
        if(key >= matrix[0][0] && key <= matrix[0][m-1]) {
            colStart = 0;
            colEnd = m-1;
            currCol = 0;
        } else if(key >= matrix[n-1][0] && key <= matrix[n-1][m-1]) {
            colStart = 0;
            colEnd = m-1;
            currCol = n-1;
        } else {

        }
        boolean row = false, col = false;
        if(rowStart >= 0) {
            while (!row) {
                rowMid = rowStart+rowEnd/2;
                if(matrix[rowMid][currRow] <= key) {
                    if(matrix[rowMid+rowEnd/2][currRow] <= key) {
                        if(rowStart == rowMid) {
                            row = true;
                        }
                        rowStart = rowMid;
                    }
                } else if(matrix[rowMid][currRow] >= key) {
                    if(matrix[rowStart+rowMid/2][currRow] >= key) {
                        if(rowEnd == rowMid) {
                            row = true;
                        }
                        rowEnd = rowMid;
                    }
                }
            }
        }

        if(colStart >= 0) {
            while (!col) {
                colMid = colStart+colEnd/2;
                if(matrix[currCol][colMid] <= key) {
                    if(matrix[currCol][colMid+colEnd/2] <= key) {
                        if(colStart == colMid) {
                            col = true;
                        }
                        colStart = colMid;
                    }
                } else if(matrix[currCol][colMid] >= key) {
                    if(matrix[currCol][colStart+colMid/2] >= key) {
                        if(rowEnd == rowMid) {
                            row = true;
                        }
                        rowEnd = rowMid;
                    }
                }
            }
        }
        System.out.println(key+" is not found");
        return false;

    }

    //q1 number 7
    public static void print7(int arr[][], int num) {
        int counter = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                if(num == arr[i][j]) {
                    counter++;
                }
            }
        }
        System.out.println("number of "+num+" is "+counter);
    }

    //q2 sum of second row
    public static void sumOfRow(int arr[][], int row) {
        int sum = 0;
        for(int i=0; i<arr[0].length; i++) {
            sum += arr[row-1][i];
        }
        System.out.println("sum of row number "+row+" is "+sum);
    }

    //q3 Transposed Matrix approch 1
    public static int[][] transposedMatrix(int arr[][]) {
        int transposedMatrix[][] = new int[arr[0].length][arr.length];
        for(int i=0; i<arr[0].length; i++) {
            for(int j=0; j<arr.length; j++) {
                transposedMatrix[i][j] = arr[j][i];
            }
        }
        return transposedMatrix;
    }

    //q3 Transposed Matrix approch 2
    public static void transposedMatrix2(int arr[][]) {
        for(int i=0; i<arr.length; i++) {
            for(int j=1+i; j<arr[0].length; j++) {
                int temp = arr[i][j];
                if(i<= arr[0].length && j<=arr.length) {
                    arr[i][j] = arr[j][i];
                }
                arr[j][i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {{10, 20, 30, 40}, 
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};
        int key = 11;
        searchInSortedMatrix(matrix, key);

        //q1
        // int arr[][] =   {{1,4,9},{11,4,3},{2,2,3} };
        // print7(arr, 7);
        // sumOfRow(arr, 3);
        int arr[][] = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        // int transposedMatrix[][] = transposedMatrix(arr);
        transposedMatrix2(arr);
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
