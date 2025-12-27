/*
 * Question: 
 * How can we generate all permutations of a given string?
 * 
 * Explanation:
 * The Permutations problem involves generating all possible arrangements of characters in a given string. 
 * We solve this problem using a recursive approach, where at each step, we choose a character from the 
 * remaining ones and append it to the current permutation until all characters are used.
 * 
 * Algorithm Steps:
 * 1. Start with an empty string as the initial permutation and the given string as the remaining characters.
 * 2. At each step, choose a character from the remaining characters and append it to the current permutation.
 * 3. Recur for the remaining characters by excluding the chosen character.
 * 4. When no more characters are left, print the current permutation.
 * 5. Repeat steps 2-4 until all permutations are generated.
 * 
 * Example:
 * For the input "abc", possible permutations are:
 * abc, acb, bac, bca, cab, cba
 * 
 * Space Complexity: O(N^2) - Space required for recursion stack and storing permutations.
 * Time Complexity: O(N!) - As there are N! possible permutations for a string of length N.
 */

package BACKTRACKING;

public class Permutations {
    
    // generate all permutations of a string
    public static void permutations(String str, String ans) {
        // Base case: all characters are used
        if(str.length() == 0) {
            System.out.println(ans); // Print the current permutation
            return;
        }

        // Recursive step: choose a character and recur for remaining characters
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // Choose a character
            String newStr = str.substring(0, i) + str.substring(i + 1); // Exclude the chosen character
            permutations(newStr, ans + ch); // Recur for remaining characters
        }
    }

    public static void main(String[] args) {
        String str = "abc"; // Given string
        permutations(str, ""); // Start with an empty permutation
    }
}
