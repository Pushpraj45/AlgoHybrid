package com.sorting;
// This is being done in a  sorted array
public class ModifiedBinarySearch {
    public static void main(String[] args){
        int arr[]={4,5,6,7,0,1,2};
        int target=0; // output->4
        int taridx=Search(arr,target,0,arr.length-1);
        System.out.println(taridx);
    }
    public static int Search(int arr[], int target, int si, int ei){

//        Base Case
        if (si>ei){
            return -1;
        }
//        Kaam
        int mid=si+(ei-si)/2;
//        Case found
        if (arr[mid]==target){
            return mid;
        }
//        mid on L1
        if (arr[si]<=arr[mid]){
//            Case a: left
            if (arr[si]<=target && target<=arr[mid] ){
                return Search(arr,target,si,mid);
            }
            else{
//                Case b: right
                return Search(arr,target,mid+1,ei);
            }
        }
//        mid on L2
        else{
//            Case c: right
            if (arr[mid]<=target&&target<=arr[ei]){
                return Search(arr,target,mid+1,ei);

            }
            else {
//                Case d: Left
            return Search(arr,target,si,mid-1);
            }
        }
    }
}
