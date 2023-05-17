package com.sorting;

public class QuickSort {
    public static void main(String[] args){
        int arr[]={2,1,3,7,4,5};
        quicksort(arr,0,arr.length-1 );
        PrintArr(arr);
    }
    public static void PrintArr(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quicksort (int arr[], int si, int ei){
        if (si>=ei){
            return;
        }
//        Last element
        int pidx=partition(arr,si,ei);
        quicksort(arr,si,pidx-1);
        quicksort(arr,pidx+1,ei);
    }
//    ye function hume pivot ke aas pass values ko sort kar dega aur hume pivot ka correct index de dega  
    public static int partition(int arr[], int si, int ei){
        int pivot=arr[ei];
        int i=si-1; // to make place for elements smaller than pivot
        for (int j=si; j<ei; j++){
            if (arr[j]<=pivot){
                i++; // if value less hai then we have to make place 
                //swap
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
//        This way we are going to find place for pivot element

        }
        i++;
//         Again we updated our pivot index value
        int temp=pivot;
        arr[ei]=arr[i]; // changing in pivot index not on it's value
        arr[i]=temp; // stored pivot at i that's why we are returning i 
return i;
    }
}
