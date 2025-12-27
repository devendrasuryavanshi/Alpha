package ArrayList;

import java.util.ArrayList;

public class BeautifulArray {

    // Approach 1(Iterative)
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);

        while (ans.size() < n) {
            ArrayList<Integer> temp = new ArrayList<>();
            
            for(int i=0; i<ans.size(); i++) {
                if((ans.get(i) * 2 -1) <= n) {
                    temp.add(ans.get(i) * 2 -1);
                }
            }

            for(int i=0; i<ans.size(); i++) {
                if((ans.get(i) * 2) <= n) {
                    temp.add(ans.get(i) * 2);
                }
            }

            ans = temp;
        }

        return ans;
    }

    // Approach 2(Divide & Conquer)
    public static void beautifulArrayDivAndCon(int start, int increment, ArrayList<Integer> ans, int n) {
        if(start + increment > n) {
            ans.add(start);
            return;
        }

        beautifulArrayDivAndCon(start, 2 * increment, ans, n);
        beautifulArrayDivAndCon(start + increment, 2 * increment, ans, n);
    }
    
    static ArrayList<Integer> ans = new ArrayList<>();
    
    public static void main(String[] args) {
        beautifulArrayDivAndCon(1, 1, ans, 4);
        System.out.println(ans);
    }
}
