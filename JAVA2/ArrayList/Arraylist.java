package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.event.InternalFrameEvent;

public class Arraylist {
    
    public static void main(String[] args) {
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(0);
        // list.add(1);
        // list.add(6);
        // list.add(3);
        // list.add(7);
        // list.add(5);

        // //print reverse
        // for(int i=list.size()-1; i>=0; i--) {
        //     System.err.print(list.get(i)+" ");
        // }

        // int max = Integer.MIN_VALUE;

        // //find maximum
        // for(int i=0; i<list.size(); i++) {
        //     max = Math.max(max, list.get(i));
        // }

        // System.out.println("Max value = "+max);

        // System.out.println(list);
        // //swap
        // int temp = list.get(1);
        // list.set(1, list.get(3));
        // list.set(3, temp);

        // System.out.println(list);
        // //ascending
        // Collections.sort(list);
        // System.out.println(list);
        // //descending
        // Collections.sort(list, Collections.reverseOrder());
        // System.out.println(list);

        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1; i<=5; i++) {
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for(int i=0; i<mainList.size(); i++) {
            ArrayList<Integer> currList = mainList.get(i);
            for(int j=0; j<currList.size(); j++) {
                System.err.print(currList.get(j)+" ");
            }
            System.out.println();
        }
    }
}
