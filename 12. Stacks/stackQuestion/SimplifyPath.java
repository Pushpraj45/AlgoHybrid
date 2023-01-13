package com.stackQuestion;
import java.util.*;
public class SimplifyPath {
    public static void main(String[] args){
        String str=new String("/home//foo/");
        System.out.println(simplify(str));
    }

    static String simplify(String A){
        Stack<String>st=new Stack<String>();
        String res="";
        res=res+"/";
        int n=A.length();
        String dir="";

        for (int i=0; i<n; i++){
            while(i<n && A.charAt(i)=='/'){
                i++;
            }
            while (i<n && A.charAt(i)!='/'){
                dir=dir+A.charAt(i);
                i++;
            }

            if(dir.equals("..")==true){
                if (!st.empty()){
                    st.pop();
                }
                else if (dir.equals(".")==true){
                    continue;
                }
                else if (dir.equals("/")==true){
                    continue;
                }
            }
            else{
//                dir= String.valueOf(A.split("/"));
                dir+=A.charAt(i);


//                if (dir.length()!=0){
//                    st.push(dir);
//                }

            }
        }
//        for (int i=0; i<dir.length(); i++){
//            if (dir.charAt(i)=="/"){
//
//            }
//        }
        Stack<String>st1=new Stack<String>();
        while (!st.empty()){
            st1.push(st.pop());

        }
        while (!st1.empty()){

                res+=st1.pop();
            }
        return res;
    }
}

