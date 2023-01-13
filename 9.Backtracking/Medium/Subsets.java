package com.Medium;

public class Subsets {
    public static void main(String[] args){
        FindSubsets("abc","",0);
    }
    public static void FindSubsets(String str, String ans, int i ){
        if (i==str.length()){
            if (ans.length()==0){
                System.out.println("null");
            }
            System.out.println(ans);
            return;
        }

//        Yes Choice
        FindSubsets(str, ans+str.charAt(i), i+1);
//        No choice
        FindSubsets(str, ans, i+1);
    }
}
