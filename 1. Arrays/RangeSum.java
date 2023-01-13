public class RangeSum {
    public static void rangeSum(int[] numbers, int n) {
    int currSum=0;
    int maxSum = Integer.MIN_VALUE;
    int prefix[] = new int[numbers.length];

    prefix[0] = numbers[0];
    int subarr[] = new int[(n * (n + 1)) / 2];

//        Calculate prefix array
        for (int i=1; i<prefix.length; i++){
        prefix[i]=prefix[i-1]+numbers[i]; // pehle ka sum + curr element ka sum
    }

        for (int i=0; i<numbers.length; i++){
        int start = i;
        for (int j=i; j<numbers.length; j++){
            int end=j;
            subarr[j] = start==0 ? prefix[end] : prefix[end] - prefix[start-1];
        }
    }
        for (int i=0; i<subarr.length; i++){
            System.out.print(subarr[i]+" ");
        }
    }

    public static void main(String[] args){
        int numbers[]={1,2,3,4};
        int n = 4, left = 1, right = 5;
        rangeSum(numbers, n);
    }
}
