/*
 * Question: 
 * How can we solve a Sudoku puzzle using backtracking?
 * 
 * Explanation:
 * The Sudoku problem is to fill a 9x9 grid with digits so that each column, each row, and each of the nine 
 * 3x3 subgrids that compose the grid contain all of the digits from 1 to 9. We solve this problem using a 
 * recursive backtracking approach, where we systematically explore all possible combinations until a solution 
 * is found.
 * 
 * Algorithm Steps:
 * 1. Implement a check if it's safe to place a digit in a particular cell based on Sudoku rules.
 * 2. Start from the top-left corner and recursively try placing digits in each cell.
 * 3. At each step, check if the current digit violates Sudoku rules. If not, place the digit and move to the 
 *    next cell.
 * 4. If all cells are filled, return true to indicate a solution is found.
 * 5. If a solution is not found, backtrack by undoing the last move and try a different digit.
 * 6. Repeat steps 3-5 until a solution is found or all possibilities are exhausted.
 * 
 * Example:
 * For the given Sudoku puzzle:
 * 5 3 0 | 0 7 0 | 0 0 0 
 * 6 0 0 | 1 9 5 | 0 0 0 
 * 0 9 8 | 0 0 0 | 0 6 0 
 * ------|-------|------
 * 8 0 0 | 0 6 0 | 0 0 3 
 * 4 0 0 | 8 0 3 | 0 0 1 
 * 7 0 0 | 0 2 0 | 0 0 6 
 * ------|-------|------
 * 0 6 0 | 0 0 0 | 2 8 0 
 * 0 0 0 | 4 1 9 | 0 0 5 
 * 0 0 0 | 0 8 0 | 0 7 9 
 * 
 * A possible solution is:
 * 5 3 4 | 6 7 8 | 9 1 2 
 * 6 7 2 | 1 9 5 | 3 4 8 
 * 1 9 8 | 3 4 2 | 5 6 7 
 * ------|-------|------
 * 8 5 9 | 7 6 1 | 4 2 3 
 * 4 2 6 | 8 5 3 | 7 9 1 
 * 7 1 3 | 9 2 4 | 8 5 6 
 * ------|-------|------
 * 9 6 1 | 5 3 7 | 2 8 4 
 * 2 8 7 | 4 1 9 | 6 3 5 
 * 3 4 5 | 2 8 6 | 1 7 9 
 * 
 * Space Complexity: O(N^2) - Space required to store the Sudoku grid.
 * Time Complexity: Exponential - As there can be 9^(N^2) possible configurations for an NxN Sudoku grid.
 */

package BACKTRACKING;

public class Sudoku {

    // check if it's safe to place a digit in a cell
    public static boolean isSafe(int sudoku[][], int row, int col, int digit) {
        int sr = (row / 3) * 3;
        int sc = (col / 3) * 3;

        // Check current grid
        for(int i = sr; i < sr + 3; i++) {
            for(int j = sc; j < sc + 3; j++) {
                if(sudoku[i][j] == digit) {
                    return false; // If digit already exists in the grid, it's not safe
                }
            }
        }

        // Check vertical and horizontal
        for(int i = 0; i < sudoku.length; i++) {
            if(sudoku[i][col] == digit || sudoku[row][i] == digit) {
                return false; // If digit already exists in the row or column, it's not safe
            }
        }

        return true; // Otherwise, it's safe to place the digit
    }

    // solve the Sudoku puzzle recursively
    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        // Base case: all cells are filled
        if(row == 9) {
            return true; // Solution found
        }

        // Calculate next cell position
        int nextRow = row, nextCol = col + 1;
        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If cell is already filled, move to next cell
        if(sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try placing digits from 1 to 9
        for(int digit = 1; digit <= 9; digit++) {
            if(isSafe(sudoku, row, col, digit)) {
                sudoku[row][col] = digit; // Place digit in the cell
                if(sudokuSolver(sudoku, nextRow, nextCol)) {
                    return true; // Recur for next cell
                }
                sudoku[row][col] = 0; // Backtrack: Undo the last move
            }
        }

        return false; // If no digit fits, backtrack
    }

    // print the Sudoku grid
    public static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < sudoku.length; i++) {
            for(int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
                if(j == 2 || j == 5) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if(i == 2 || i == 5) {
                System.out.println("------+-------+------");
            }
        }
    }

    public static void main(String[] args) {
        int sudoku[][] = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if(sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution exists:");
            printSudoku(sudoku); // Print the solution
        } else {
            System.out.println("Solution does not exist");
        }
    }
}
