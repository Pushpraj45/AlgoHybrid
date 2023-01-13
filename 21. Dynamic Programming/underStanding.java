public class underStanding {

//    converting our recursion code of fibonacci to DP
    public static void main(String[] args){
        int n=5;
        int dp[]=new int[n+1];

//        memoization
        System.out.println(fibmemoization(n,dp));
//        Tabulation
        System.out.println(fibTabulation(n));
//        Recursion
        System.out.println(fibRecursion(n));


    }
//      Tabulation code ->
    public static int fibTabulation(int n){
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n]; // answer
    }

//    Memoization code ->
    public static int fibmemoization(int n, int dp[]){
        if (n==0 || n==1){
            return n;
        }

        if (dp[n]!=0){
            return dp[n]; // fib(n) calculated
        }

        dp[n]=fibmemoization(n-1, dp)+fibmemoization(n-2, dp);

        return dp[n];
    }

//    Normal Recursion
    public static int fibRecursion(int n){
        if (n==0 || n==1){
            return n;
        }

        return fibRecursion(n-1)+fibRecursion(n-2);
    }
}
