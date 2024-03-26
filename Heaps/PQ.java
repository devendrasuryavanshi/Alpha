package Heaps;
import java.sql.Struct;
import java.util.*;

public class PQ {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new Student("A", 3));// O(logn)
        pq.add(new Student("B", 2));
        pq.add(new Student("C", 4));
        pq.add(new Student("D", 1));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+" - "+pq.peek().rank);// O(1)
            pq.remove();// O(logn)
        }
    }
}
