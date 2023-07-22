import java.util.EnumMap;

public class MaxSubarraySum {

//    Brute - Force - > bad method
    public static void maxSubarraysum(int arr[]){
        int currSum=0;
        int maxSum = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++){
            int start=i;
            for (int j=i; j<arr.length; j++){
                int end=j;
                currSum=0;
                for (int k=start; k<=end; k++){

                    currSum += arr[k];
                }
                System.out.print(currSum+" ");
//                if (maxSum<currSum){
//                    maxSum=currSum;
//                }
            }
        }
        System.out.println("max sum = "+maxSum);
    }



//    Prefix Sum Approach -> O(n^2)
    public static void maxSubArraySum(int numbers[]){
        int currSum=0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];

//        Calculate prefix array
        for (int i=1; i<prefix.length; i++){
            prefix[i]=prefix[i-1]+numbers[i]; // pehle ka sum + curr element sum
        }

        for (int i=0; i<numbers.length; i++){
            int start = i;
            for (int j=i; j<numbers.length; j++){
                int end=j;

                currSum= start==0?prefix[end] : prefix[end] - prefix[start-1];

                if (maxSum<currSum){  //O(n^2)
                    maxSum=currSum;
                }
            }
        }
        System.out.println("max sum is "+maxSum);

    }

//    Kadane's Algorithm ->  negative number ko add hi mat karo -> O(n)

    public static void kadane(int arr[]){
        int ms=Integer.MIN_VALUE;
        int cs=0;

        for (int i=0; i<arr.length; i++){
            cs=cs+arr[i];
            if (cs<0){
                cs=0;
            }
            ms=Math.max(cs,ms);
        }
        System.out.println("Max sum is "+ms);  // array mein sabhi element negative hai to smallest element print kar sakte hai

    }

    public static void main(String[] args){
        int arr[]={1,2,3,4};
        maxSubarraysum(arr);
        // maxSubArraySum(arr); //   O(n^3)
    }
}
