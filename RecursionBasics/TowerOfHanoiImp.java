package RecursionBasics;

public class TowerOfHanoiImp {

    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n == 1) {
            System.out.println("transfer disk "+n+" from "+src+" to "+dest);
            return;
        }

        //transfer top n-1 from src to helper usingdest as 'helper'
        towerOfHanoi(n-1,src,dest,helper);
        //transfer nth from src to dest
        System.out.println("transfer disk "+n+" from "+src+" to "+dest);
        //transfer n-1 from helper to dest using srcas 'helper'
        towerOfHanoi(n-1,helper,src,dest);
    }

    public static void printStringReverse(String str) {
        int n = str.length();
        if(n == 0){
            return;
        }
        System.out.print(str.charAt(n-1));
        printStringReverse(str.substring(0, n-1));
    }

    public static void firstAndLast(String str, int idx, char key, boolean map[]) {
        int n = str.length();
        if(map[0] && map[1] || idx == n) {
            return;
        }

        if(str.charAt(idx) == key && !map[0]) {
            System.out.println(idx+"th index is the first occurance of "+key);
            map[0] = true;
        }

        if(str.charAt(n-idx-1) == key && !map[1]) {
            System.out.println((n-idx-1)+"th index is the last occurance of "+key);
            map[1] = true;
        }

        firstAndLast(str, idx+1, key, map);
    }
    
    public static void main(String[] args) {
        // towerOfHanoi(2, "A", "B", "C");
        // printStringReverse("abcd");
        firstAndLast("appnnaccolnege", 0, 'a', new boolean[2]);
    }
}
