import java.util.*;
class MyStack {
    static Queue<Integer>q1;
    static Queue<Integer>q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    public boolean empty() {
        return q1.isEmpty()&& q2.isEmpty();
    }
    public void push(int data) {

        if (!q1.isEmpty()){
            q1.add(data);
        }
        else{
            q2.add(data);
        }
    }

    public int pop() {
        int top=-1;

        while (!q1.isEmpty()){
            top=q1.remove();
            if (q1.isEmpty()){
                break;
            }
            q2.add(top);
        }

        while (q2.isEmpty()){
        top=q2.remove();
        if (q2.isEmpty()){
            break;
        }
        q1.add(top);
    }
            return top;
}

    public int top() {
        int topp=-1;

        while (!q1.isEmpty()){
            topp=q1.remove();
            q2.add(topp);
        }


                while (q2.isEmpty()){
                        topp=q2.remove();
                        q1.add(topp);
                        }

                        return topp;



                        }
                        }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */