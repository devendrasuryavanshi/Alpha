package GreedyAlgorithms;
import java.util.*;

public class IndianCoin {
    public static void main(String[] args) {
        int rupee[] = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> a = new ArrayList<>();

        int price = 1059;
        int total = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        while (price > 0 && i < rupee.length) {
            if(rupee[i] <= price) {
                ans.add(rupee[i]);
                total += rupee[i];
                price -= rupee[i];
            } else {
                i++;
            }
        }

        System.out.println("total = " + total);
        System.out.println("Total num of coins = " + ans);
    }
}
