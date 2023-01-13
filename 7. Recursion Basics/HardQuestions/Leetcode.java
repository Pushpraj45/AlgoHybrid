package com.HardQuestions;

import java.util.Arrays;

public class Leetcode {
    public static String RemoveDuplicates(String str, int index, StringBuilder newStr, boolean[] map){
        if (index==str.length()){
            return newStr.toString();
        }
        char Currchar=str.charAt(index);
        if (map[Currchar-'a']==true){
            // Duplicate
            RemoveDuplicates(str,index+1,newStr,map);
        }
        else {
            map[Currchar-'a']=true;
            RemoveDuplicates(str,index+1,newStr.append(Currchar),map);
        }
        char charArray[]=newStr.toString().toCharArray();
        Arrays.sort(charArray);
        return (new String(charArray));
    }
    public static void main(String[] args){

        String str="bcabc";
        System.out.println(RemoveDuplicates(str,0,new StringBuilder(""),new boolean[26]));

    }
}
