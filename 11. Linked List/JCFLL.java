package com.collectionFrameWork;
import java.util.LinkedList;
public class JCFLL {
    public static void main(String[] args){
//        Create - objects int , float, boolean -> Integer, Float, Character etc classes
        LinkedList<Integer>ll=new LinkedList<>();  // same as ArrayList
//        Add
        ll.addLast(3);
        ll.addLast(1);
        ll.addFirst(4);
        ll.addLast(2);
        System.out.println(ll);

//        Remove
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll.size());
    }
}
