import java.util.LinkedList;
import java.util.Queue;


public class FirsNonRepeating {
    public static void FirstNonRepeat(String str){
        int frq[]=new int[26]; // 'a'-'z'
        Queue<Character> q=new LinkedList<>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            q.add(ch);
            frq[ch-'a']++;

            while(!q.isEmpty() && frq[q.peek()-'a']>1){
                q.remove();
            }


            if (q.isEmpty()){
                System.out.println(-1);
            }
            else{
                System.out.println(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        String str="aabccxb ";
        FirstNonRepeat(str);
    }
}
