/*
 * Question: 
 * How do we find a path for a rat in a maze from the starting cell to the ending cell?
 * 
 * Explanation:
 * The Rat in a Maze problem is a classic problem where we have a maze with obstacles, and we need to find a path
 * for a rat from the starting cell (0,0) to the ending cell (n-1,n-1), where 1 represents a valid cell and 0 represents
 * an obstacle. We use a recursive backtracking approach to explore all possible paths until we find the solution.
 * 
 * Algorithm Steps:
 * 1. Start from the starting cell (0,0) and explore all possible paths recursively.
 * 2. At each step, check if the current cell is a valid cell and not already visited.
 * 3. If the current cell is the ending cell, mark it as part of the solution and print the maze configuration.
 * 4. Otherwise, try moving to the next cell in either the right direction or the down direction.
 * 5. If no valid path is found, backtrack to the previous cell and try a different path.
 * 6. Repeat steps 2-5 until a solution is found or all paths are explored.
 * 
 * Visual Representation:
 * '1' represents a valid cell, '0' represents an obstacle, and '1' represents the path taken by the rat.
 * 
 * Example:
 * For the maze:
 * 1 1 1 1
 * 1 0 0 1
 * 1 0 0 1
 * 1 1 1 1
 * 
 * A possible solution path would be:
 * 1 0 0 0
 * 1 0 0 0
 * 1 0 0 0
 * 1 1 1 1
 * 
 * 1 1 1 1
 * 0 0 0 1 
 * 0 0 0 1 
 * 0 0 0 1 
 * 
 * Space Complexity: O(N^2) - The space required to store the solution matrix.
 * Time Complexity: Exponential - As there can be 2^(n^2) possible paths in the worst case.
 */

package BACKTRACKING;

public class RatInAMaze {
 
    // check if the rat can move to a specific cell
    public static boolean isSafe(int maze[][], int row, int col) {
        // Check if the cell is within the maze boundaries and not an obstacle
        return (row >= 0 && row < maze.length && col >= 0 && col < maze.length && maze[row][col] == 1);
    }
 
    // find the path for the rat in the maze
    public static void ratInAMaze(int maze[][], int row, int col, int solve[][]) {
        // Base case: rat reaches the end of the maze
        if(row == maze.length-1 && col == maze.length-1 && maze[row][col] == 1) {
            solve[row][col] = 1; // Mark the ending cell as part of the solution
            printMaze(solve); // Print the maze configuration
            return;
        }
 
        // Recursive step: explore all possible paths
        if(isSafe(maze, row, col)) {
            if(solve[row][col] == 1) {
                return; // If already visited, return
            }
 
            solve[row][col] = 1; // Mark the current cell as visited
 
            // Move to the next cell in either right or down direction
            ratInAMaze(maze, row+1, col, solve);
            ratInAMaze(maze, row, col+1, solve);
 
            solve[row][col] = 0; // Backtrack: unmark the current cell
        }
        return;
    }

    // print the maze configuration
    public static void printMaze(int solve[][]) {
        for(int i = 0; i < solve.length; i++) {
            for(int j = 0; j < solve.length; j++) {
                System.out.print(solve[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int maze[][] = {{1, 1, 1, 1},
                        {1, 0, 0, 1},
                        {1, 0, 0, 1},
                        {1, 1, 1, 1}};
        
        int n = maze.length;
        int solve[][] = new int[n][n]; // Initialize solution matrix

        ratInAMaze(maze, 0, 0, solve); // Find path for rat

        if(solve[n-1][n-1] == 0) {
            System.out.println("Solution doesn't exist"); // If no solution found
        }
    }
}
 