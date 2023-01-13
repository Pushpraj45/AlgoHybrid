package com.Basics;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PairSum {
    public static void main(String[] args){
        ArrayList<Integer>list=new ArrayList<>();
//        Arraylist is Sorted
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        int target=5;
        PairSum1(list,target);
        PairSum2(list,target);

//        For PairSum - 3
        ArrayList<Integer>list1=new ArrayList<>();
        list1.add(11);
        list1.add(15);
        list1.add(6);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        PairSum3(list1,target);
    }
//    Brute Force - O(n^2)
    public static boolean PairSum1(ArrayList<Integer>list,int target){
        for (int i=0; i<list.size(); i++){
            for (int j=0; j<list.size(); j++){
                if (list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;
    }
//    2 - Pointer Approach - O(n)
    public static boolean PairSum2(ArrayList<Integer>list, int target){
        int lp=0;
        int rp=list.size()-1;
       while (lp!=rp){
            if (list.get(lp)+list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+list.get(rp)<target){
                lp++;
            }
            else{
                rp--;
            }
        }
        return false;
    }

//    Find if any Pair in a Sorted and Rotated ArrayList has a target Sum
//    2 Pointer Approach - O(n)
    public static boolean PairSum3(ArrayList<Integer>list1, int target){
        int bp=-1;
        for (int i=0; i<list1.size(); i++){
            if (list1.get(i)>list1.get(i+1)){
                bp=i;
                break;
            }
        }
        int lp=bp+1;
        int rp=bp;
        while (lp!=rp){
            if (list1.get(lp)+list1.get(rp)==target){
                return true;
            }
            if (list1.get(lp)+ list1.get(rp)<target){
                lp=(lp+1)%list1.size();
            }
            if (list1.get(lp)+ list1.get(rp)>target){
                rp=(list1.size()+rp-1)%list1.size();
            }
        }
        return false;
    }

}
