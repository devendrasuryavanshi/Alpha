/*
 * Question: 
 * How can we find a Knight's tour on a chessboard, where a knight visits every square exactly once?
 * 
 * Explanation:
 * The Knight's Tour problem is to find a sequence of moves for a knight on a chessboard such that the knight 
 * visits every square exactly once. We solve this problem using a recursive backtracking approach, exploring 
 * all possible moves until a solution is found.
 * 
 * Algorithm Steps:
 * 1. Define arrays to represent the possible moves a knight can make relative to its current position.
 * 2. Start from the initial position (0,0) and recursively explore all possible moves.
 * 3. At each step, check if the next move is safe and not already visited.
 * 4. If a safe move is found, mark the current position with the move number and recursively call the function 
 *    for the next move.
 * 5. If all moves are exhausted and a solution is found, return true.
 * 6. If no solution is found, backtrack by undoing the last move and continue exploring other paths.
 * 7. Repeat steps 2-6 until a solution is found or all possibilities are exhausted.
 * 
 * Example:
 * For an 8x8 chessboard, a possible Knight's tour can be:
 * 0  59  38  33  30  17   8  63 
 * 37  34  31  60   9  62  29  16 
 * 58   1  36  39  32  27  18   7 
 * 35  48  41  26  61  10  15  28 
 * 42  57   2  49  40  23   6  19 
 * 47  50  45  54  25  20  11  14 
 * 56  43  52   3  22  13  24   5 
 * 51  46  55  44  53   4  21  12 
 * 
 * Space Complexity: O(N^2) - Space required to store the solution matrix.
 * Time Complexity: O(8^(N^2)) - As there can be 8 possible moves at each step and there are N^2 squares 
 *                    to be visited.
 */

package BACKTRACKING;

public class KnightsTour {
    
    // Arrays to represent possible moves of a knight
    final static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}, yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

    // check if the next move is safe
    public static boolean isSafe(int solve[][], int x, int y) {
        return (x >= 0 && y >= 0 && x < solve.length && y < solve.length && solve[x][y] == -1);
    }

    // recursively find Knight's tour
    private static boolean keypadCombinations(int solve[][], int x, int y, int move) {
        // Base case: all squares are visited
        if(move == solve.length * solve.length) {
            return true;
        }

        // Try all possible moves from the current position
        for(int i = 0; i < xMove.length; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            // Check if the next move is safe and not visited
            if(isSafe(solve, nextX, nextY)) {
                solve[nextX][nextY] = move; // Mark the current position with the move number
                if(keypadCombinations(solve, nextX, nextY, move + 1)) {
                    return true; // Recur for the next move
                } else {
                    solve[nextX][nextY] = -1; // Backtrack: undo the last move
                }
            }
        }

        return false;
    }

    // print the solution matrix
    public static void printSol(int solve[][]) {
        for(int i = 0; i < solve.length; i++) {
            for(int j = 0; j < solve.length; j++) {
                System.out.print(solve[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int solve[][] = new int[8][8]; // Initialize solution matrix
        
        // Initialize solution matrix with -1
        for(int i = 0; i < solve.length; i++) {
            for(int j = 0; j < solve.length; j++) {
                solve[i][j] = -1;
            }
        }

        solve[0][0] = 0; // Mark the starting position
        if(keypadCombinations(solve, 0, 0, 1)) { // Find Knight's tour
            printSol(solve); // Print the solution matrix
        } else {
            System.out.println("Solution doesn't exist"); // If no solution found
        }

    }
}
