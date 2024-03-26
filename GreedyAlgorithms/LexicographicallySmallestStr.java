package GreedyAlgorithms;

import java.util.*;

public class LexicographicallySmallestStr {

    public static String lexicographically(int N, int K) {
        char ch[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while (N > 0) {
            if((N-1)*26 >= K-i) {
                sb.append(ch[i-1]);
                N--;
                K -= i;
            } else {
                i = Math.min(K-(N-1), 26);
            }
        }

        // sb.reverse();
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(lexicographically(2, 29));
    }
}
