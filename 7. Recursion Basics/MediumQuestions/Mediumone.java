package com.MediumQuestions;
public class Mediumone {
    public static void main(String[] args){
        int arr[]={1,2,3,4,5,5,5,5};
        System.out.println(IsSorted(arr,0));
        System.out.println(FirstOccurence(arr,5,0));
        System.out.println(LastOccurence(arr,5,0));
        System.out.println(power(2.0000,10));
    }
    public static boolean IsSorted(int arr[], int i){
        if (i== arr.length-1){
            return true;
        }
        if (arr[i]>arr[i+1]){
            return false;
        }
        return IsSorted(arr,i+1);
    }

//    Function for finding first Occurence of an element in an array
    public static int FirstOccurence(int arr[],  int key, int i){ // First compare with self and then look forward
        if (i==arr.length){
            return -1;
        }
        if (arr[i]==key) {
            return i;
        }
        return FirstOccurence(arr,key,i+1);
    }

    //    Function for finding Last Occurence of an element in an array
    public static int LastOccurence(int arr[], int key, int i){  // Look forward then compare with self
        if (i==arr.length){
            return -1;
        }
        // Look forward now
        int isFound= LastOccurence(arr,key,i+1);
        if (isFound!=-1)
        {
            return isFound;
        }

//        Check with self
        if (arr[i]==key){
            return i;
        }
        return isFound;
    }
    public static double power(double x, int n){
        if(n==0){
            return 1;
        }
        double xnm1=power(x,n-1);
        double xn=x*xnm1;
        return xn;

        /*
        or we can write in one line like this and jab tak base case hit nahi hota hai call jate rhegi
        return x * power(x,n-1)

        This method takes O(n) time complexity and completes the process
         */

    }
    public static int OptimizedPower(int x, int n){
        if (n==0){
            return 1;
        }
        int halfpower=OptimizedPower(x,n/2);
        int halfpowersq=halfpower*halfpower;

//        n is odd then multiply one more time them
        if (n%2!=0){
            halfpowersq=x*halfpowersq;
        }
        return halfpowersq;
    }
}
