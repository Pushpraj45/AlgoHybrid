package com.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcodcheck {
    public List<Integer> findLonely(int[] arr) {
//        List<Integer>arr=ArrayToListConversion(nums);
        Arrays.sort(arr);
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=1; i<arr.length-1; i++){
            if (arr[i-1]+1< arr[i] && arr[i]+1<arr[i+1]){
                list.add(arr[i]);
            }
        }
        if (arr.length==1){
            list.add(arr[0]);
        }
        if (arr.length>1){
            if (arr[0]+1<arr[1]){
                list.add(arr[0]);
            }
            if (arr[(arr.length-2)]+1<arr[arr.length-1]){
                list.add(arr[arr.length-1]);
            }
        }
        return list;
    }
}
