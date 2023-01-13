package com.Important;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args){  //O(n)
         int arr[]={6, 8, 0, 1, 3};

        Stack<Integer> s=new Stack<>();
        int nextGreater[]= new int[arr.length];

        for (int i=arr.length-1; i>=0; i--){
//            While loop
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
//            If-else
            if (s.isEmpty()){
                nextGreater[i]=-1;
            }
            else{
                nextGreater[i]=arr[s.peek()];
            }

//            push in stack
            s.push(i);
        }
        for (int i=0; i<nextGreater.length; i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println();
    }
}

// next greater right - just in solved
// next greater left - loop condition reverse
// next smaller right - condition p2 while loop change
// next smaller left - both 2 and 3 to do
