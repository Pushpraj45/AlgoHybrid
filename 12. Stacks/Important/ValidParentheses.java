package com.Important;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String str){  //O(n)
        Stack<Character>s=new Stack<>();
        for (int i=0; i<str.length(); i++){
            char ch=str.charAt(i);

            if (ch=='(' || ch=='{' || ch=='['){ //Opening parentheses
                s.push(ch);
            }
            else{
                if (s.isEmpty()){
                    return false;
                }
                if ((s.peek()=='(' && ch==')') //()
                || (s.peek()=='{' && ch=='}')  //{}
                || (s.peek()=='[' && ch==']')){ //[]
                    s.pop();
                }
                else {
                return false;
            }
            }
        }
        if (s.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args){
        String str="({})[]";
        System.out.println(isValid(str));
    }
}
