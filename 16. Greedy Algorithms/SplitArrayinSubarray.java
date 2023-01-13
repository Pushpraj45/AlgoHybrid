public class SplitArrayinSubarray {
    public static void main(String[] args){
        int arr[]={1,2,3,4};
        int k=3;
        int n=4;
        Splitting(arr,n,k,0,0,0);
        System.out.println(ans);
    }
    public static int ans=1000000;
    public static void Splitting(int arr[], int n, int k, int index, int sum, int maxsum){
        if (k==1){
            maxsum=Math.max(maxsum, sum);
            sum=0;
            for (int i=index; i<n; i++){
                sum+=arr[i];
            }
            maxsum=Math.max(maxsum,sum);
            ans=Math.min(ans,maxsum);
            return;
        }
        sum=0;
        for (int i=index; i<n; i++){
            sum+=arr[i];
            maxsum=Math.max(maxsum,sum);
            Splitting(arr,n,k-1,i+1,sum,maxsum);
        }

    }
}
