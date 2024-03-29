package com.Simple;
public class Arrays {
    public static void main(String[] args){
        int arr[]={1,2,3,4,5};
        ChangeArr(arr,0,1);
        PrintArr(arr);

    }
    public static void PrintArr(int arr[]){
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void ChangeArr(int arr[] , int i, int value){
//         Base Case
        if (i==arr.length){
            PrintArr(arr);
            return;
        }
//        Recursion steps
        arr[i]=value; // assigning value
        ChangeArr(arr,i+1, value+1); // fnx recursive call step 
        arr[i]=arr[i]-2;                    // Backtracking Step
    }
}
