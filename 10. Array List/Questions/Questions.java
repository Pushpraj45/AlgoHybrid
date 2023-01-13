package com.Questions;

import java.util.ArrayList;
import java.util.Collections;

public class Questions {
    public static void main(String[] args){
//        Monotonic ArrayList
//        ArrayList<Integer>nums=new ArrayList<>();
//        nums.add(1);
//        nums.add(2);
//        nums.add(3);
//        nums.add(2);
////        System.out.println(Ismonotonic(nums));
//
//        ArrayList<Integer>nums1=new ArrayList<>();
//        nums1.add(10);
//        nums1.add(6);
//        nums1.add(5);
//        nums1.add(8);
//        System.out.println(LonelyNumbers(nums1));

        ArrayList<Integer>nums2=new ArrayList<>();
        nums2.add(2);
        nums2.add(1000);
        nums2.add(2);
        nums2.add(1000);
        nums2.add(2);
        nums2.add(3);
        System.out.println(MostFrequent(nums2,2));

//        ArrayList<Integer>nums3=new ArrayList<>();
//        nums1.add(1);
//        nums1.add(100);
//        nums1.add(200);
//        nums1.add(1);
//        nums1.add(100);
//        System.out.println(MostFrequent(nums2,1));
//
//        System.out.println(BeautifulArray(5));

    }
//    public static boolean Ismonotonic(ArrayList<Integer>nums){
//        boolean inc = true;
//        boolean dec = true;
//        for (int i=0; i<nums.size()-1; i++){
//            if (nums.get(i)>nums.get(i+1)){
//                inc=false;
//            }
//            if (nums.get(i)<nums.get(i+1)){
//                dec=false;
//            }
//        }
//        return inc||dec;
//
//    }

    public static ArrayList<Integer> LonelyNumbers(ArrayList<Integer>arr){
        Collections.sort(arr);
        ArrayList<Integer>list=new ArrayList<>();
        for (int i=1; i<arr.size()-1; i++){
            if (arr.get(i-1)+1<arr.get(i) && arr.get(i)+1<arr.get(i+1)){
                list.add(arr.get(i));
            }
        }
        if (arr.size()==1){
            list.add(arr.get(0));
        }
        if (arr.size()>1){
            if (arr.get(0)+1<arr.get(1)){
                list.add(arr.get(0));
            }
            if (arr.get(arr.size()-2)+1<arr.get(arr.size()-1)){
                list.add(arr.get(arr.size()-1));
            }
        }
        return list;
    }
    public static int MostFrequent(ArrayList<Integer>nums, int key){
        int[] result= new int[1010];
        for (int i=0; i<nums.size()-1; i++){
            if (nums.get(i)==key){
                result[nums.get(i+1)-1]++;
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=0;
        for (int i=0; i<1010; i++){
            if (result[i]>max){
                max=result[i];
                ans=i+1;
            }
        }
        return ans;
    }

//    Beautiful Array
    public static ArrayList<Integer> BeautifulArray(int n){
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(1);

        for (int i=2; i<=n; i++){
            ArrayList<Integer>temp=new ArrayList<>();
            for (Integer e:ans)
                if (2 * e <= n) {
                    temp.add(e * 2);
                }
            for (Integer e:ans){
                if (2*e-1<=n){
                    temp.add(e*2-1);
                }
            }
            ans=temp;
        }
        return ans;
    }
}
