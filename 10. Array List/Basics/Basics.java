package com.Basics;
import java.util.ArrayList;

public class Basics {
    public static void main(String[] args){
//        Same as Vectors and are part Java collection Frameworks
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<String> list1=new ArrayList<>();

//        Adding an element - O(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3,9); // Takes O(n)
        System.out.println(list);

//        Get Operation - O(1)
        int element = list.get(2);
        System.out.println(element);

//        Remove - O(n)
        list.remove(2);
        System.out.println(list);

//        Set elements at index - O(n)
        list.set(2,10);
        System.out.println(list);

//        Contains - O(n)
        System.out.println(list.contains(2));

//        Size oof arraylist
        System.out.println(list.size());

//        Iterating in arraylist
//        Printing the arraylist
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //    Reverse of an arrayList
        for (int i=list.size()-1; i>=0; i--){
            System.out.print(list.get(i));
        }
        System.out.println();

//        Finding Maximum in arraylist
        int max=Integer.MIN_VALUE;
        for (int i =0; i<list.size(); i++){
//            if (list.get(i)>max){
//                max= list.get(i);
//            }
            max=Math.max(max,list.get(i));
        }
        System.out.println(max);

//        Swapping two numbers
        int idx1=1, idx2=3;

    }
    public static void swap(ArrayList<Integer>list, int idx1, int idx2){
        int temp=list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }


}
