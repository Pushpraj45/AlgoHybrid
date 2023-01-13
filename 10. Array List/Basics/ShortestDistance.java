package com.Basics;

import java.util.ArrayList;

//Input: s = "loveleetcode", c = "e"
//Output: [3,2,1,0,1,0,0,1,2,2,1,0]
public class ShortestDistance {
    public static ArrayList<Integer> ShortestChar(String s, char c){
        ArrayList<Integer> ans=new ArrayList<>();
        int j=0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i)==c){
                ans.add(j-i);
                j++;
            }
            else{
                ans.add(j-i);
            }
        }
      return ans;
    }
    public static void main(String[]  args){
        System.out.println(ShortestChar("loveleetcode",'e'));
    }
}
