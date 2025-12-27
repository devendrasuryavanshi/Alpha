package GreedyAlgorithms;
import java.util.*;

public class MaxBalancedStrPartitions {

    public static ArrayList<String> maxBalancedStrPartitions(String str) {
        ArrayList<String> s = new ArrayList<>();

        String st1 = "";
        String st2 = "";
        int count = 0;

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == 'L') {
                st1 += ch;
            } else {
                st2 += ch;
            }

            if(st1.length() == st2.length()) {
                s.add(str.substring(i-(st1.length()*2)+1, i+1));
                count++;
                st1 = st2 = "";
            }
        }

        return s;
    }
    
    public static void main(String[] args) {
        String str = "LRLLRRLRRL";
        System.out.println(maxBalancedStrPartitions(str));
    }
}
