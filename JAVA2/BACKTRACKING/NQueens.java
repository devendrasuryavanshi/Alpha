/*
 * Question: 
 * How can we solve the N-Queens problem using backtracking?
 * 
 * Explanation:
 * The N-Queens problem is to place N chess queens on an N×N chessboard so that no two queens attack each other.
 * We solve this problem using backtracking, which involves systematically searching through all possible solutions 
 * until the correct one is found. At each step, we try to place a queen in a safe position, and if it's not possible, 
 * we backtrack and try another position.
 * 
 * Algorithm Steps:
 * 1. Start with an empty chessboard represented by a 2D array of size N×N, filled with '-' representing empty cells.
 * 2. Begin with the first row and move to the next row recursively.
 * 3. For each row, try placing the queen in each column.
 * 4. If the queen can be placed safely (i.e., no other queen attacks it), mark that cell as 'Q' and move to the next row.
 * 5. If no safe position is found in the current row, backtrack by changing the previous queen's position and try a different column.
 * 6. Repeat steps 3-5 until all queens are placed on the board.
 * 7. Once all queens are placed, print the board configuration.
 * 
 * Visual Representation:
 * '-' represents empty cells, 'Q' represents queen, '-' represents unoccupied cells.
 * 
 * Example:
 * For N = 4, a possible solution looks like:
 * 
 *  - Q - - 
 *  - - - Q 
 *  Q - - - 
 *  - - Q - 
 */

 package BACKTRACKING;

 public class NQueens {
 
    // Function to check if placing a queen at a specific position is safe
    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertical up
        for(int i = row-1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
 
        // Check diagonal left up
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
 
        // Check diagonal right up
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
 
         return true;
     }
 
     // Function to recursively place queens on the board
     public static boolean nQueens(char board[][], int row) {
         // Base case: all queens are placed
         if(row == board.length) {
            // printBoard(board);
            count++;
            return true;
         }
 
         // Try placing queen in each column of current row
         for(int j = 0; j < board.length; j++) {
             if(isSafe(board, row, j)) {
                 board[row][j] = 'Q'; // Place queen
                 if(nQueens(board, row+1)) {
                    return true;
                 }
                 board[row][j] = '-'; // Backtrack: remove queen
             }
         }
         return false;
     }
 
     // Function to print the board configuration
     public static void printBoard(char board[][]) {
         System.out.println("---------- Chess Board ----------");
         for(int i = 0; i < board.length; i++) {
             for(int j = 0; j < board.length; j++) {
                 System.out.print(board[i][j] + " ");
             }
             System.out.println();
         }
     }
     static int count = 0;
     public static void main(String[] args) {
         int n = 4; // Board size
         char board[][] = new char[n][n]; // Initialize board
         // Initialize board with empty cells
         for(int i = 0; i < board.length; i++) {
             for(int j = 0; j < board.length; j++) {
                 board[i][j] = '-';
             }
         }
         if(nQueens(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
         } else {
            System.out.println("solution is not possible");
         }
        //  System.out.println("total ways to solve n Queens = " + count);
     }
 }
 