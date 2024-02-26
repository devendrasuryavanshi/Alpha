/*
Time Complexity:

The algorithm explores two possible moves at each step: down (i+1) and right (j+1).
At each step, it makes two recursive calls to explore these moves.
In the worst-case scenario, the algorithm explores all possible paths from the starting point (0, 0) to the bottom-right corner (n-1, m-1) of the grid.
Since at each step, there are two recursive calls made, and the grid is of size n × m, the total number of function calls will be 2^(n+m).
Therefore, the time complexity of the algorithm is O(2^(n+m)).

Space Complexity:

The space complexity is determined by the maximum depth of recursion, which is limited by the size of the grid.
In the worst-case scenario, the maximum depth of recursion will be n+m-1 when the algorithm traverses either all rows or all columns to reach the bottom-right corner of the grid.
Therefore, the space complexity of the algorithm is O(n+m).
*/

package BACKTRACKING;

public class GridWays { 

    //(OWN) time: O(2^n+m); space: O(n+m)
    public static void gridWays(int grid[][], int row, int col) {
        //base case
        if(row == grid.length-1 && col == grid[0].length-1) {
            count++;
            return;
        }

        //right move
        if(col != grid[0].length-1) {
            gridWays(grid, row, col+1);
        }

        //down move
        if(row != grid.length-1) {
            gridWays(grid, row+1, col);
        }
    }
    static int count = 0;

    //(DIDI) time: O(2^n+m); space: O(n+m)
    public static int gridWays2(int i, int j, int n, int m) {
        //base case
        if(i == n-1 && j == m-1) {
            return 1;
        } else if(i == n || j== n) {
            return 0;
        }

        //down move
        int w1 = gridWays2(i+1, j, n, m);
        //right
        int w2 = gridWays2(i, j+1, n, m);

        return w1 + w2;
    }

    //optimised
    public static void gridWaysOpt(int i, int j, int n, int m) {
        if(i == n && j == m) {
            System.out.println("total ways to achive the index[n*m] = " + count);
        }
    }
    
    public static void main(String[] args) {
        int grid[][] = new int[2][3];
        gridWays(grid, 0, 0);
        System.out.println("total ways to achive the index[n*m] = " + count);
    }
}
