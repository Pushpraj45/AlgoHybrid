import java.util.Deque;
import java.util.LinkedList;

public class DequeImplement
{
    public static void main(String[] args){
        Deque<Integer>deque=new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

//        some other operations are as follows
//        getFirst, getLast, removefirst , RemoveLast
        System.out.println(deque);
    }
}
