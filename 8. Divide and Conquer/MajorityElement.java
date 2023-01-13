package com.sorting;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {3, 2, 3};
//        System.out.println(majority(nums));
        System.out.println(majorityElement(nums));

    }
    /*
    Approach -1 Takes O(n^2) complexity

    public static int majority(int[] arr){

        int majorityCount=arr.length/2;
        int count=0;
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (arr[j]==arr[i]){
                        count++;
                }
            }
            if (count>majorityCount){
                return arr[i];
            }
        }
        return -1;

    }

     */

//    Approach -2 Divide and conquer which takes O(nlogn) complexity

    public static int CountRange(int[] nums, int num, int si, int ei){
        int count=0;
        for (int i=si; i<=ei; i++){
            if (nums[i]==num){
                count++;

            }
        }
        return count;
    }
    public static int majorityElement(int[] nums, int si, int ei){
//        Base case
//        The only element in an array of size 1 is the majority
        if (si==ei){
            return nums[si];
        }

//        Recurse on left and right halves of this slice
        int mid=si+(ei-si)/2;
        int left=majorityElement(nums,si,mid);
        int right=majorityElement(nums,mid+1,ei);

//        if the two halves agree on the majority element , return it
        if (left==right){
            return left;
        }
//        Otherwise, count each element and return the winner
        int leftcount=CountRange(nums,left,si,ei);
        int rightcount=CountRange(nums,right,si,ei);

        return leftcount>rightcount? left:right;
    }
    public static int majorityElement(int[] nums){
        return majorityElement(nums,0,nums.length-1);
    }
}
