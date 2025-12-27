package RecursionBasics;

import java.util.Scanner;
//AMAZON

// Tiling problem: 
// Given a 2xn board and tiles of size 2X1, count the number of ways 
// to tile the given board using the 2X1 tiles. 
// A tile can either be placed horizontally or vertically.

// Explanation:
// The problem asks to find the number of ways to tile a 2xn board 
// using tiles of size 2X1. We can approach this problem using 
// dynamic programming.

// We can tile the board either horizontally or vertically. 
// If we place a tile horizontally, it covers 2 consecutive columns. 
// If we place it vertically, it covers only one column.

// To count the number of ways to tile the board, we can consider 
// the following cases:
// 1. If n = 1, there is only one way to tile the board, which is 
//    to place a vertical tile.
// 2. If n = 2, there are two ways to tile the board: either place 
//    two vertical tiles or one horizontal tile.
// 3. For n > 2, the number of ways to tile the board can be 
//    calculated by adding the number of ways to tile a board of 
//    size (n-1) and the number of ways to tile a board of size 
//    (n-2). This is because we can place a vertical tile in the 
//    nth column, followed by tiling the remaining (n-1) columns, 
//    or we can place two horizontal tiles in the nth and (n-1)th 
//    columns, followed by tiling the remaining (n-2) columns.

// Example:
// Consider a 2x4 board. v = | and h = - - 
//                           |
// To tile it, we have the following possibilities:
// - Place 4 vertical tiles, resulting in a board like this:
//   | | | |
//   | | | |
// - Place 4 horizontal tile, resulting in a board like this:
//   - - - -
//   - - - -
// - Place 2 vertical and 2 horizontal tile, resulting 
//   in a board like this:
//   | | - -
//   | | - -
// - Place 2 horizontal and 2 vertical tile, resulting 
//   in a board like this:
//   - - | |
//   - - | |
// - Place 1 vertical and 2 horizontal and 1 vertical tiles, resulting in a board like this:
//   | - - |
//   | - - |
// total Ways are 5
public class RecursionBasics2 {
    public static int tillingProblem(int n) {
        //base case
        if(n == 0 || n == 1) {
            return 1;
        }
        //     horizontal choice     vertical choice
        return tillingProblem(n-1) + tillingProblem(n-2);
    }

    // GOLDMAN SACHS
    // Question 13
// Friends Pairing Problem:
// Given n friends, each person can either remain single or can 
// be paired up with another friend. Each friend can be paired 
// with only one other friend. The task is to find the total 
// number of ways in which friends can be paired up.

// Explanation:
// The problem can be solved using recursion or dynamic programming.
// Let f(n) be the total number of ways in which n friends can be 
// paired up. 
// We can consider two cases for the first friend:
// 1. The first friend remains single, then the problem reduces to 
//    finding the number of ways to pair up the remaining (n-1) 
//    friends, i.e., f(n-1).
// 2. The first friend can be paired up with any of the remaining 
//    (n-1) friends. After pairing up the first friend, the problem 
//    reduces to finding the number of ways to pair up the remaining 
//    (n-2) friends, i.e., f(n-2) because the second friend in the 
//    pair cannot be paired up with anyone else.

// Therefore, the recursive formula for the problem is:
// f(n) = f(n-1) + (n-1) * f(n-2)

// Example:
// Suppose we have 3 friends (n = 3).
// Let's denote the friends as A, B, and C.
// - A remains single, and we find the number of ways to pair up 
//   B and C. This contributes to f(2).
// - A can be paired up with either B or C. Suppose A pairs up with B. 
//   Now, we need to find the number of ways to pair up C. This 
//   contributes to (n-1) * f(n-2), where n = 3 and n-2 = 1. 
//   There is only one way to pair up C.
// - Similarly, if A pairs up with C, there is only one way to pair 
//   up B.
// Hence, the total number of ways to pair up the friends is f(3) = 4.

// Visual Idea:
// For example, if we have 4 friends (A, B, C, D):
// - A can remain single, and we find the number of ways to pair up 
//   B, C, and D.
// - A can pair up with B, leaving us with C and D to pair up.
// - A can pair up with C, leaving us with B and D to pair up.
// - A can pair up with D, leaving us with B and C to pair up.
// For each case, we recursively find the number of ways to pair up 
// the remaining friends.
    public static int friendsPairing(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        //     single                n of p  pair
        return friendsPairing(n-1) + (n-1) * friendsPairing(n-2);
    }

    //Question 14; Binary String Problem; print all binary string of size N withought consecutive ones; eg. N=2 print(1) = 00, print(2) = 10 and print(3) 01, but not 11;
    public static void printBinString(int n, int lastPlace, String str) {
        if(n == 0) {
            System.out.println(str);
            return;
        }
        printBinString(n-1, 0, str+"0");

        if(lastPlace == 0) {
            printBinString(n-1, 1, str+"1");
        }
    }

    //Practice Questions --

    // Question 1:For a given integer array of size N. You have to find all the
    // occurrences (indices) of a given element (Key) and print them. Use arecursive
    // function to solve this problem.
    // Sample Input: arr[ ] = {3, 2, 4, 5, 6, 2, 7, 2, 2}, key = 2 
    // Sample Output: 1 5 7 8
    public static void occurrencesIndices(int arr[], int key, int n) { //(OWN)
        //base case
        if(n == arr.length-1) {
            if(arr[n] == key) {
                System.out.print(n+" ");
            }
            return;
        }

        if(arr[n] == key) {
            System.out.print(n+" ");
        }

        occurrencesIndices(arr, key, n+1);
    }

    // Question 2 :You are given a number (eg -  2019), convert it into a String of 
    // english like“two zero one nine”.  Use a recursive function to solve this problem.
    // NOTE - The digits of the number will only be in the range 0-9 and the last digit of
    // a number can’t be 0.
    // Sample Input: 1947
    // Sample Output: “one nine four seven”
    public static StringBuilder numToEngString(int num, StringBuilder newStr, String str[]) { // (OWN)
        //base case
        if(num/10 == 0) {
            // add first num's String
            return newStr.append(str[num]);
        }


        if(num > num/10) {
            numToEngString(num/10, newStr, str);
        }

        return newStr.append(" "+str[num%10]);
    }

    //Question 3 : Write a program to findLength of aStringusing Recursion.(DIDI)
    public static int length(String str) {
        if(str.length() == 0) {
            return 0;
        }
        
        return length(str.substring(1)) +1;
    }

    public static int sameStartEndCharSubStr(String str, int i, int j, int n) {
        if(n == 1) {
            return 1;
        }

        if(n <= 0) {
            return 0;
        }

        int res = sameStartEndCharSubStr(str, i+1, j, n-1) + sameStartEndCharSubStr(str, i, j-1, n-1) - sameStartEndCharSubStr(str, i+1, j-1, n-2);

        if(str.charAt(i) == str.charAt(j)) {
            res++;
        }

        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // boolean are = true;
        // while (are) {
        //     System.out.println("enter num, and to end '-1'");
        //     int n = sc.nextInt();
        //     if(n == -1) {
        //         are = false;
        //         continue;
        //     }
        //     printBinString(n, 0, "");
        // }

        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        String str[] = {"zero", "one", "two", "three", "four", "five", "fix", "seven", "eight", "nine"};
        // System.out.println(numToEngString(1947, new StringBuilder(""), str));
        // System.out.println(length("abcd"));
        String string = "aaaaa";
        int n = string.length();
        System.out.println(sameStartEndCharSubStr(string, 0, n-1, n));
        System.out.println(friendsPairing(4));
    }
}
