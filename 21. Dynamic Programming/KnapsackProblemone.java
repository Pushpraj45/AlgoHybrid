public class KnapsackProblemone {
    public static void main(String[] args){
        int val[]={15, 14, 10, 45, 30};
        int wt[]={2,5,1,3,4};
        int W=7;
//        Recursion
        System.out.print(knapsack(val,wt,W,val.length));
//        Memoization
        int dp[][]=new int[val.length+1][W+1];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                dp[i][j]=-1;
            }
        }

        System.out.print(knapsack1(val,wt,W,val.length, dp));


//        Tabulation
//        print(dp);
        System.out.println(knapsack2(val,wt,W));


//        unbounded knapsack
        System.out.println(unboundedKnapsack(val,wt,W));

    }
    public static int knapsack(int val[], int wt[], int W, int n){
        if (W==0 || n==0){
            return 0;
        }
        if (wt[n-1]<=W){  // item no se usse minus 1 kar denge to uska index aa jaayega
//            include
            int ans1=val[n-1]+knapsack(val, wt, W-wt[n-1], n-1);
//            exlude
            int ans2=knapsack(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        }
        else{
            return knapsack(val,wt,W,n-1);
        }
    }

//    Memoization way
    public static int knapsack1(int val[], int wt[], int W, int n, int dp[][]){
        if (W==0 || n==0){
            return 0;
        }
        if (dp[n][W]!=-1){
            return dp[n][W];
        }
        if (wt[n-1]<=W){
            int ans1=val[n-1]+knapsack1(val, wt, W-wt[n-1], n-1, dp);

            int ans2=knapsack1(val,wt, W, n-1, dp);

            dp[n][W]=Math.max(ans1,ans2);

            return dp[n][W];
        }

        else{
            dp[n][W]=knapsack1(val, wt, W, n-1, dp);
            return dp[n][W];
        }

    }

//    Tabulation
    public static int knapsack2(int val[], int wt[], int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        for (int i=0; i<dp.length; i++){   // 0th col
            dp[i][0]=0;
        }
        for (int j=0; j<dp[0].length; j++){  //0th row
            dp[0][j]=0;
        }

        for (int i=1; i<n+1; i++){
            for (int j=1; j<W+1; j++ ){
             int v=val[i-1];  //ith item val
             int w=wt[i-1];   //ith item wt
                if (w<=j){   // valid
                    int incprofit=v+dp[i-1][j-w];
                    int excprofit=dp[i-1][j];
                    dp[i][j]=Math.max(incprofit, excprofit);
                }
                else{ // invalid
                    int excprofit=dp[i-1][j];
                    dp[i][j]=excprofit;
                }
            }
        }
        print(dp);
        return dp[n][W];   // max profit will be at the end of 2D array
    }
    public static int unboundedKnapsack(int val[], int wt[], int W){
        int n=val.length;
        int dp[][]=new int[n+1][W+1];

        for (int i=0; i<n+1; i++){
            dp[i][0]=0; // by default ye java mein hota hi hai
        }
        for (int j=0; j<W+1; j++){
            dp[0][j]=0;
        }
        for (int i=1; i<n+1; i++){
            for (int j=1; j<W+1; j++){
                if (wt[i-1]<=j){ // valid
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]], dp[i-1][j]);
                }
                else { //invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
    public static void print(int dp[][]){
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
