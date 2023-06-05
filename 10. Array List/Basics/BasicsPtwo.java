package com.Basics;

import java.util.ArrayList;
import java.util.Collections;

public class BasicsPtwo {
    public static void main(String[] args){
//        Sorting in arrayList - using collections in java
        ArrayList<Integer>list=new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(8);
        list.add(5);
        list.add(6);
        System.out.println(list);
        Collections.sort(list); // Ascending Order
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
//        Comparator - fnx Logic
        System.out.println(list);

//        Implementation of arraylist
        /*
        Firstly arraylist are implemented as array of a fixed size and when we
        have made that amount of arraylist after adding element in it then system
        increases the size of new array by 2 times(it varies from java versions) and
        copies all the element of previous array and it goes on
         */

//        2D - arraylist
        ArrayList<ArrayList<Integer>>mainlist=new ArrayList<>();
        ArrayList<Integer>list1=new ArrayList<>();
        list1.add(2);
        list1.add(3);
        mainlist.add(list1);
        ArrayList<Integer>list2=new ArrayList<>();
        list2.add(2);
        list2.add(3);
        mainlist.add(list2);

        for (int i=0; i< mainlist.size(); i++){
            ArrayList<Integer>currList=mainlist.get(i);
            for (int j=0; j< currList.size(); j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }

        System.out.println(mainlist);


//        Adding 3 list in one mainlist so that we can identify the things
        ArrayList<ArrayList<Integer>>mainlist1=new ArrayList<>();
        ArrayList<Integer>Alist1=new ArrayList<>();
        ArrayList<Integer>Alist2=new ArrayList<>();
        ArrayList<Integer>Alist3=new ArrayList<>();

        for (int i=1; i<=5; i++){
            Alist1.add(i*1); // 1 2 3 4 5
            Alist2.add(i*2); // 2 4 6 8 10
            Alist3.add(i*3); // 3 6 9 12 15
        }
        mainlist1.add(Alist1);
        mainlist1.add(Alist2);
        mainlist1.add(Alist3);

        for (int i=0; i< mainlist1.size(); i++){
            ArrayList<Integer>currList1=mainlist1.get(i);
            for (int j=0; j< currList1.size(); j++){
                System.out.print(currList1.get(j)+" ");
            }
            System.out.println();
        }
    }
}
