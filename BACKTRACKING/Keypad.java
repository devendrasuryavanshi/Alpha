/*
 * Question: 
 * How can we generate all possible letter combinations that can be formed using the digits on a phone keypad?
 * 
 * Explanation:
 * The Keypad Combinations problem involves generating all possible combinations of letters that can be formed 
 * by pressing the digits on a phone keypad. Each digit can represent a set of letters according to the standard 
 * phone keypad layout. We use a recursive backtracking approach to explore all possible combinations.
 * 
 * Algorithm Steps:
 * 1. Create a 2D array where each index corresponds to a digit and contains an array of letters associated 
 *    with that digit on a phone keypad.
 * 2. Start from the first digit and explore all possible combinations of letters recursively.
 * 3. For each digit, get the array of letters associated with that digit and iterate through each letter.
 * 4. Append the current letter to the string builder and recursively call the function for the next digit.
 * 5. When all digits are processed, print the generated combination.
 * 6. Backtrack by deleting the last character appended to the string builder before moving to the next letter.
 * 7. Repeat steps 3-6 until all combinations are generated.
 * 
 * Visual Representation:
 * Each digit corresponds to a set of letters:
 * 2 -> {'a','b','c'}
 * 3 -> {'d','e','f'}
 * ...
 * 
 * Example:
 * For the input "23", possible combinations are:
 * ad, ae, af, bd, be, bf, cd, ce, cf
 * 
 * Space Complexity: O(N) - Space required for recursion stack, where N is the length of the input string.
 * Time Complexity: O(4^N) - As each digit can have 3 or 4 associated letters and there can be N digits 
 *                    representing the string length, leading to a total of 4^N possible combinations.
 */

package BACKTRACKING;

public class Keypad {

    // Array representing the letters associated with each digit on a phone keypad
    final static char letters[][] = {{}, {}, {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'}, {'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'}};

    // generate all possible combinations of letters from the keypad
    public static void keypadCombinations(String dig, int pos, StringBuilder sb) {
        // Base case: all digits are processed
        if(pos == dig.length()) {
            System.out.println(sb.toString());
        } 
        // Recursive step: explore all possible combinations
        else {
            char letter[] = letters[Character.getNumericValue(dig.charAt(pos))];
            for(int i = 0; i < letter.length; i++) {
                sb.append(letter[i]); // Append current letter to the string builder
                keypadCombinations(dig, pos + 1, sb); // Recur for next digit
                sb.deleteCharAt(sb.length() - 1); // Backtrack: delete last character
            }
        }
    }

    public static void main(String[] args) {
        keypadCombinations("23", 0, new StringBuilder());
    }
}
