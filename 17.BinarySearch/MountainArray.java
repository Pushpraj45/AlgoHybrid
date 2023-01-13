package BinarySearch;

public class MountainArray {
    public static void main(String[] args){

    }

    public static int peakIndexInMountainArray(int[] arr){
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;
            if (arr[mid]>arr[mid+1]){
//                you are in dec part of array crossed largest element
//                this may be the ans but look at the left
//                this is why end! = mid-1
                end=mid;
            }
            else{
//                you are in the asc part of array
                start=mid+1; // because we know that mid+1 element > mid element
            }
        }
//        in the end , start==end and pointing to the largest number because of the two checks above
//        start and end are always trying to find max element in the above 2 checks
//        hence , when they are pointing to just one element , that is the max one because that is what check say
//        more elaboration :- at every point of time for the start and end , they have the best possible answer till that time
//        hence, if we are saying that only one time is remaining , so that is the best possible ans
        return start; // return end both are equal
    }
}
