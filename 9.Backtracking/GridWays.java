package com;

public class GridWays {
    public static void main(String[] args){
        System.out.println( gridWays(0,0,2,3));
    }
    public static int gridWays(int i, int j, int n, int m){
//        Base case
        if (i==n-1 && j==m-1){  // Condition for last cell
            return 1;
        }
        else if (i==n || j==m){  // Boundary cross condition
            return 0;
        }
        int w1=gridWays(i+1,j,n,m);
        int w2=gridWays(i,j+1,n,m);
        return w1+w2;
    }
}
