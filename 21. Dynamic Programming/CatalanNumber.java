import java.util.Arrays;

public class CatalanNumber {
//      Recursion
    public static int catalan(int n){
        if (n==0 || n==1){
            return 1;
        }

        int ans=0;
        for (int i=0; i<=n-1; i++){
            ans+=catalan(i)* catalan(n-i-1);
        }
        return ans;
    }
    public static int CatalanMem(int n, int dp[]){
         if (n==0 || n==1){
             return 1;
         }
         if (dp[n]!=-1){
             return dp[n];
         }

         int ans=0;
         for (int i=0; i<n; i++){
             ans+=CatalanMem(i, dp) * CatalanMem(n-1-i, dp);
         }
         return dp[n]=ans;
    }

    public static int catalanTab(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i=2; i<=n; i++) // Ci
        {
            for (int j=0; j<i; j++){
                dp[i]+=dp[j]*dp[i-j-1];   //Ci = Cj * Ci-j-1 variable change kar diya hai
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=4;
//        Recursion ->> stack overflow error
        System.out.println(catalan(n));
//        Memoization ->> Better than Recursion
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(CatalanMem(n,dp));

//        Tabulation
        System.out.println(catalanTab(n));
    }
}
