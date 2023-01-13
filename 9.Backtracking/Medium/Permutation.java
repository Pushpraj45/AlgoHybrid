package com.Medium;

public class Permutation {
    public static void main(String[] args){

    }
    public static void FindPermutation(String str, String ans){
//        Base case
        if (str.length()==0){
            System.out.println(ans);
            return;
        }
//        Recursion
        for (int i=0; i<str.length(); i++){
            char curr=str.charAt(i);
//          abcde-> ab+de=abde
            String newStr=str.substring(0,i)+str.substring(i+1); // Removed i from this step
            FindPermutation(newStr, ans+curr);
        }
    }
}
