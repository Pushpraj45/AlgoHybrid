package com.Important;

import java.util.Stack;

public class DuplictateParentheses {
public static void main(String[] args){
//    Valid String
    String str="((a+b))";  //true
    String str2="(a-b)";  //false
    System.out.println(IsDuplicate(str));
}
public static boolean IsDuplicate(String str){
    Stack<Character>s=new Stack<>();
    for (int i=0; i<str.length(); i++){
        char ch=str.charAt(i);
//    Closing condition
    if (ch==')') {
        int count = 0;
        while (s.peek() != '(') {
            s.pop();
            count++;
        }
        if (count < 1) {
            return true; // Duplicate
        } else {
            s.pop(); // opening pair
        }
    }
        else{
         s.push(ch);   // opening
        }
    }
    return false;



}
}

