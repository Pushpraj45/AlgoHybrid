package com.Important;
import java.util.*;
public class MaxArea {
    public static void main(String[] args){
        int arr[]={2,4};
        MaxArea(arr);

//     }here thr concept of next greater element is more important 
    public static void MaxArea(int arr[]){
        int maxArea=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int [arr.length];

//        Next Smaller Right
        Stack<Integer>s=new Stack<>();

        for (int i=arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
//        Next smaller Left
        s=new Stack<>();

        for (int i=0; i<arr.length; i++){
            while (!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if (s.isEmpty()){
                nsl[i]=arr.length;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
//        Current Area - width = j-i-1 = nsr[i]-nsl[i]-1

        for (int i=0; i<arr.length; i++){
            int height=arr[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=height*width;
            maxArea=Math.max(currArea,maxArea);
        }

        System.out.println("Maximum area in histogram is "+maxArea);

    }
}
/*
https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/2736294/Largest-Rectangle-in-Histogram
 */
