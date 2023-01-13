import java.util.*;

public class Questions {
    public static void main(String[] args){

        int n=10;
        generateBinary(n);

    }

//    generate and printing all binary numbers values till range
    public static void generateBinary(int n){
        Queue<String>q=new LinkedList<String>();
        q.add("1");
        while (n-->0){
            String s1=q.peek();
            q.remove();
            System.out.println(s1);
            String s2=s1;
            q.add(s1+"0");
            q.add(s2+"1");
        }
    }

//    Connect ropes with minimum cost
    public static int minCost(int arr[], int n){
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for (int i=0; i<n; i++){
            pq.add(arr[i]);
        }
        int res=0;
        while (pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            res+=first+second;
            pq.add(first+second);
        }
        return res;
    }

//    Job Sequencing problem
//        will do by greedy method


//    Reversing the first K elements of a Queue
    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k){
        Stack<Integer> st=new Stack<>();
        int shift=k;
        while (k>0){
            st.push(q.peek());
            q.remove();
            k--;

        }
        while (!st.isEmpty()){
            q.add(st.peek());
            st.pop();
        }

        int temp=q.size()-shift;
        while (temp>0){
            q.add(q.peek());
            q.remove();
            temp--;
        }
        return q;
    }

//    Sliding window maximum
    public static void PrintMax(int arr[], int n, int k){
        Deque<Integer>Qi=new LinkedList<Integer>();
        int i;
        for ( i=0; i<k; ++i){
            while (!Qi.isEmpty()&& arr[i]>=arr[Qi.peekFirst()]){
                Qi.removeLast();
                Qi.addLast(i);

            }
        }
        for (; i<n; ++i){
            System.out.println(arr[Qi.peek()]+" ");
            while (!Qi.isEmpty() && Qi.peek()<=i-k){
                Qi.removeFirst();
                while ((!Qi.isEmpty()) && arr[i]>=arr[Qi.peekLast()]){
                    Qi.removeLast();
                    Qi.addLast(i);
                }
            }
        }
        System.out.println(arr[Qi.peek()]);

    }
}
