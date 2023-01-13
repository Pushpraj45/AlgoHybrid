package com.basics;
// It means counting of 1 in a number

public class CountSetBits {
    public static void main(String[] args){
    int n=10;
    int count=0;
    while(n>0){
        if ((n&1)!=0){ // Count your LSB
            count++;
        }
        n=n>>1; // Moved bits of n using right shift operator
    }
        System.out.println("Total number of set bits are "+count);

}
}
