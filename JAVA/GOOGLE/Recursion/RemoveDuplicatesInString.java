package GOOGLE.Recursion;

public class RemoveDuplicatesInString {

    //Question 12 of part2; Remove duplicates in a string; eg. intput str"appnnacollege" = output: "apncoleg";
    public static void removeDuplicatesInString(String str, int idx, StringBuilder newStr, boolean map[]) {
        //base case
        if(idx == str.length()) {
            System.out.println(newStr);
            return;
        }

        //work
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true) {
            //duplicate
            removeDuplicatesInString(str, idx+1, newStr, map);
        } else {
            map[currChar-'a'] = true;
            removeDuplicatesInString(str, idx+1, newStr.append(currChar), map);
        }
    }
    
    public static void main(String[] args) {
        String str = "appnnacollege";
        removeDuplicatesInString(str, 0, new StringBuilder(""), new boolean[26]);
    }
}
