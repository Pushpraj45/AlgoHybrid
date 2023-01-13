package com.Questions;

public class InversionCount {
    public static void main(String[] args){
        int arr[]={2, 4, 1, 3, 5};
        System.out.println("Inversion count = "+getInversions(arr));


    }
/*    Approach-1 Brute Force TC - O(n^2)
    public static int getInvcount(int arr[]){
        int n=arr.length;
        int invCount=0;
        for (int i=0; i<n-1; i++){
            for (int j=i+1; j<n; j++){
                if (arr[i]>arr[j]){
                    invCount++;
                }
            }
        }
        return invCount;
    }

 */
public static int mergeSort(int arr[], int si, int ei){
    int invCount=0;
    if (ei>si){
        int mid=(ei+si)/2;
        invCount=mergeSort(arr,si,mid);
        invCount+=mergeSort(arr,mid+1,ei);
        invCount+=merge(arr,si,mid+1, ei);
    }
    return invCount;
}
    public static int merge(int arr[], int si, int mid, int ei){
        int i=si, j=mid,k=0;
        int invcount=0;
        int temp[]=new int[(ei-si+1)];
        while ((i<mid) && j<=ei){
            if (arr[i]<=arr[j]){
                temp[k]=arr[i];
                k++;
                i++;
            }
            else{
                temp[k]=arr[j];
                invcount+=mid-i;
                k++;
                j++;
            }
        }
        while (i<mid){
            temp[k]=arr[i];
            k++;
            i++;

        }
        while (j<=ei){
            temp[k]=arr[j];
            k++;
            j++;
        }
        for (i=si, k=0; i<=ei; i++, k++){
            arr[i]=temp[k];
        }
        return invcount;
    }

    public static int getInversions(int arr[]){
        int n=arr.length;
        return mergeSort(arr,0,n-1);
    }

}
