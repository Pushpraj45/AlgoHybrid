package com.stackQuestion;
import java.util.*;
public class DecodeString {
    public static void main(String[] args){

    }
    public static String decode(String str){
        Stack<Integer> integerStack=new Stack<>();
        Stack<Character>stringstack=new Stack<>();
        String temp="",result="";
        for (int i=0; i<str.length(); i++){
            int count=0;
            if (Character.isDigit(str.charAt(i))){
                while (Character.isDigit(str.charAt(i))){
                    count=count*10+str.charAt(i)-'0';
                    i++;
                }
                i--;
                integerStack.push(count);
            }
            else if (str.charAt(i)==']'){
                temp="";
                count=0;
                if (!integerStack.isEmpty()){
                    count=integerStack.peek();
                    integerStack.pop();
                }
                while (!stringstack.isEmpty()&& stringstack.peek()!='['){
                    temp=stringstack.peek()+temp;
                    stringstack.pop();
                }
                if (!stringstack.empty()&& stringstack.peek()=='['){
                    stringstack.pop();
                }
                for (int j=0; j<count; j++){
                    result=result+temp;
                }
                for (int j =0; j<result.length(); j++){
                    stringstack.push(result.charAt(j));
                }
                result="";
            }
            else if (str.charAt(i)=='['){
                if (Character.isDigit(str.charAt(i-1))){
                    stringstack.push(str.charAt(i));
                }
                else{
                    stringstack.push(str.charAt(i));
                    integerStack.push(1);
                }
            }
            else {
                stringstack.push(str.charAt(i));
            }

        }
        while (!stringstack.isEmpty()){
            result=stringstack.peek()+result;
            stringstack.pop();
        }
        return result;
    }
    public static String decodee(String s){
        Stack<Integer>counts=new Stack<>();
        Stack<String>result=new Stack<>();
        String res="";
        int index=0;
        while (index<s.length()){
            if (Character.isDigit(s.charAt(index))){
                int count=0;
                while (Character.isDigit(s.charAt(index))){
                    count=10*count+(s.charAt(index)-'0');
                    index+=1;
                }
                counts.push(count);
            }
            else if (s.charAt(index)=='['){
                result.push(res);
                res="";
                index+=1;
            }
            else if (s.charAt(index)==']'){
                StringBuilder temp=new StringBuilder(result.pop());
                int count=counts.pop();
                for (int i=0; i<count; i++){
                    temp.append(res);
                }
                res=temp.toString();
                index++;
            }
            else {
                res+=s.charAt(index);
                index+=1;
            }
        }
        return res;
    }
}
