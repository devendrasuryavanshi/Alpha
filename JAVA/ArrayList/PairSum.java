package ArrayList;

import java.util.ArrayList;

public class PairSum {

    //sort array
    public static ArrayList<Integer> pairSum(ArrayList<Integer> list, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        int lp = 0, rp = list.size()-1;

        while (lp < rp) {
            if(target == list.get(lp) + list.get(rp)) {
                ans.add(list.get(lp)); ans.add(list.get(rp));
                return ans;
            }

            if(list.get(lp) + list.get(rp) < target) {
                lp++;
            } else {
                rp--;
            }
        }

        return ans;
    }

    // sorted and rotated pairSum
    public static ArrayList<Integer> pairSum2(ArrayList<Integer> list, int target) {
        //breaking point
        int bp = 0;
        for(int i = 1; i<list.size(); i++) {
            if(list.get(i) < list.get(i-1)) { //breaking point
                bp = i;
                break;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        int lp = bp; //smallest
        int rp = bp-1; //largest
        int n = list.size();

        while (lp != rp) {
            if(target == list.get(lp) + list.get(rp)) {
                ans.add(list.get(lp)); ans.add(list.get(rp));
                return ans;
            }

            if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1) % n;
            } else {
                rp = (n+rp-1) % n;
            }
        }
    
        return ans;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        //11, 15, 6, 8, 9, 10 - sorted and rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        // System.out.println(pairSum(list, 5));
        System.out.println(pairSum2(list, 16));
    }
}
