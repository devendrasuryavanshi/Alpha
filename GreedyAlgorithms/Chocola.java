package GreedyAlgorithms;
import java.util.*;

public class Chocola {
    
    public static void main(String[] args) {
        int n = 4, m = 6;
        Integer costVer[] = {2, 1, 3, 1, 4}; // m-1
        Integer costHor[] = {4, 1, 2}; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int cuts = 0;
        int h = 0, v = 0;
        while (v < costVer.length && h < costHor.length) {
            if(costVer[v] >= costHor[h]) {
                cuts += (h+1) * costVer[v];
                v++;
            } else {
                cuts += (v+1) * costHor[h];
                h++;
            }
        }

        //remaining vertical
        while (v < costVer.length) {
            cuts += (h+1) * costVer[v];
            v++;
        }

        //remaining Horizontal
        while (h < costHor.length) {
            cuts += (v+1) * costHor[h];
            h++;
        }

        System.out.println("Min total cuts = " + cuts);
    }
}
