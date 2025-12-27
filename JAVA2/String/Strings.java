package String;

import java.util.*;

public class Strings {
    public static void printStr(String str) {
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i));
        }
    }

    //check if I string is a palindrome
    public static boolean isPalindrome(String str) {
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                System.out.println(str+" is not a palindrome");
                return false;
            }
        }
        System.out.println(str+" is a palindrome");
        return true;
    }

    //shortest path
    public static float shortestPath(String str) {
        int n = str.length();
        int x = 0;
        int y = 0;
        for(int i=0; i<n; i++) {
            //East
            if(str.charAt(i) == 'E') {
                x++;
            } 
            //West
            else if(str.charAt(i) == 'W') {
                x--;
            } 
            //North
            else if(str.charAt(i) == 'N') {
                y++;
            }
            //South
            else {
                y--;
            }
        }
        x *= x;
        y *= y;
        return (float) Math.sqrt(x+y);
    }

    //subString
    public static String subString(String str, int si, int ei) {
        String sub = "";
        for(int i=si; i<ei; i++) {
            sub += str.charAt(i);
        }
        return sub;
    }

    // uppercase first letter of each words
    public static StringBuilder upLetter(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            if(i==0 || str.charAt(i-1)==' ') {
                char ch = Character.toUpperCase(str.charAt(i));
                sb.append(ch);
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb;
    }


    //didi method
    public static String upString2(String str) {
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i)==' ' && i<str.length()-1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //String compression
    public static String compress(String str) {
        StringBuilder newStr = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            Integer c = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                c++;
                i++;
            }
            newStr.append(str.charAt(i));
            if(c>1) {
                newStr.append(c.toString());
            }
        }
        return newStr.toString();
    }

    //Lowercase vowels count
    public static int countLowercaseVowels(String str) {
        int count = 0;;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }
        return count;
    }

    //anagrams
    public static boolean isAnagrams(String str1, String str2) {
        if(str1.length() != str2.length()) {
            System.out.println(str1+" and "+str2+" are not Anagrams");
            return false;
        }
        //String int char array
        char[] str1CharArr = str1.toCharArray();
        char[] str2CharArr = str2.toCharArray();
        //sort array
        Arrays.sort(str1CharArr);
        Arrays.sort(str2CharArr);

        //check for are equal
        boolean isAnagrams = Arrays.equals(str1CharArr, str2CharArr);

        if(isAnagrams) {
            System.out.println(str1+" and "+str2+" are Anagrams");
            return true;
        }

        System.out.println(str1+" and "+str2+" are not Anagrams");
        return false;
    }
    
    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd'};
        String str = "aaabbcccdd";

        //Strings are IMMUTABLE
        Scanner sc = new Scanner(System.in);
        // System.out.println(str.substring(0, 5));
        // System.out.println(subString(str, 0, 5));
        // compare in lexicograph
        // String fruits[] = {"apple", "mango", "banana"};
        // String largest = fruits[0];
        // for(int i=0; i<fruits.length; i++) {
        //     if(largest.compareToIgnoreCase(fruits[i]) < 0) {
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);

        //stringBuilder
        // StringBuilder sb = new StringBuilder("");
        // for(char ch='a'; ch<='z'; ch++) {
        //     sb.append(ch);
        // }
        // System.out.println(countLowercaseVowels("DevendrA"));
        // String st ="ApnaCollege".replace("l","");
        // System.out.println(isAnagrams("abcd", "dcba"));
        // System.out.println(6>>1);
        System.out.println('!' - ' ');
    }
}
