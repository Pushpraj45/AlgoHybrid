import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class PQ {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student (String name, int rank){
            this.name=name;
            this.rank=rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank-s2.rank;
        }
    }

    public static void main(String[] args){
//        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
//        pq.add(3);
//        pq.add(1);
//        pq.add(7);
//        pq.add(5);

        PriorityQueue<Student> pq=new PriorityQueue<>();
        pq.add(new Student("A", 4));
        pq.add(new Student("B", 1));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 45));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+" -> "+pq.peek().rank);  //O(1)
            pq.remove();  //O(logn)  // can also reverse via writing comparator. reverseOrder();

        }
    }
}
