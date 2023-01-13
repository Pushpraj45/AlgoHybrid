import java.util.Stack;

public class Questions {
    public static void pushAtbottom(Stack<Integer> s, int data){
        if (s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtbottom(s,data);
        s.push(top);
    }

    public static String reverseString(String str){
        Stack<Character>s=new Stack<>();
        int idx=0;
        while (idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder res=new StringBuilder("");
        while (!s.isEmpty()){
            char curr=s.pop();
            res.append(curr);
        }
        return res.toString();
    }
    public static void PrintStack(Stack<Integer>s){
        while (!s.isEmpty()){
            System.out.println(s.pop());
        }
    }

    public static void ReverseStack(Stack<Integer>s){
        if (s.isEmpty()){
            return;
        }
        int top=s.pop();
        ReverseStack(s);
        pushAtbottom(s,top);

    }
    public static void main(String[] args){

/*        For push At Bottom
        Stack<Integer>s=new Stack<>();
        s.push(0);
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtbottom(s,5);
        PrintStack(s);

//        For Reversing a String
        String str="abc";
        String result=reverseString(str);
        System.out.println(result);

 */
//        For Reversing a Stack
        Stack<Integer>s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
//        3 2 1
        ReverseStack(s);
        PrintStack(s);


    }
}
