package com.sorting;
public class MergeSort {
    public static void main(String[] args){
int arr[]={6,3,9,5,2,8};
mergeSort(arr,0,arr.length-1);
PrintArr(arr);
    }
public static void mergeSort(int arr[], int si, int ei){
        if (si>=ei){
            return;
        }

//        Kaam
    int mid=si+(ei-si)/2;   //(si+ei)/2
    mergeSort(arr,si,mid);
    mergeSort(arr,mid+1,ei);
    merge(arr,si,mid,ei);

}
public static void merge(int arr[], int si, int mid, int ei){
//        left-> (0,3) = 4 elements right->(4,6) = 3 elements->total 7 which we get from below formula
        int temp[]=new int[ei-si+1];
        int i=si; // iterator for left part
        int j=mid+1; // iterator for right part
        int k=0;  // iterator for temp array

        while (i<=mid && j<=ei){
            if (arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k]=arr[j];
                j++;
                k++;
            }
        }

//        Suppose koi part jaldi khatam hogaya tab ke liye ye code
//    Left part
    while (i<=mid){
        temp[k++]=arr[i++];
    }
//    Right part
    while (j<=ei){
        temp[k++]=arr[j++];
    }

//    Copy temp to original array
    for (k=0, i=si; k<temp.length; k++, i++){
        arr[i]=temp[k];
    }
}

public static void PrintArr(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.println(
                    arr[i]+" ");

        }
    System.out.println();
}
}
//Time Complexity - O(nlogn)
/* Approach
Divide
mergeSort(left)
mergeSort(Right)
merge them in sorted order

 */
