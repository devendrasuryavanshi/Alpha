package GreedyAlgorithms;

import java.util.*;

public class ActivitySelection {
    
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //sorting
        int activities[][] = new int[start.length][3];
        for(int i=0; i<start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lamda function -> sortform
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<String> ans = new ArrayList<>();
        int maxAct = 1;
        ans.add("A0");
        int lastEnd = activities[0][2];

        for(int i=1; i<end.length; i++) {
            if(activities[i][1] >= lastEnd) {
                //activity select
                maxAct++;
                lastEnd = activities[i][2];
                ans.add("A"+Integer.toString(i));
            }
        }

        System.out.println("max activity = "+maxAct);
        System.out.println(ans);
    }
}
