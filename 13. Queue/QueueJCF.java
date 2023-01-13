import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class QueueJCF {
    public static void main(String[] args){
        Queue<Integer> q=new LinkedList<>(); //ArrayDeque
//        As we know queue is an interface not a class and we can never create
//        objects of the interfaces
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
