package com.basics;

import java.util.Set;

// Note - Bit mask that affects the ith position is 1<<i
public class Operations {
    public static void main(String[] args){
        System.out.println( GetithBit(15,2));
        System.out.println(SetithBit(15,2));
        System.out.println(UpdateithBit(15,2,1));
        System.out.println(ClearIbits(15,2));
        System.out.println(clearRangeBits(10,2,4));
    }
    public static int GetithBit(int n, int i){
        int Bitmask = 1<<i; // i - which bit you want in given number
        if ((n & Bitmask)==0){ // AND we have performed because it will not change the number just give us the ith bit
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int SetithBit(int n, int i){ // it means to set ith bit in 1
        int bitmask=1<<i;
        return n|bitmask;
    }
    public static int ClearithBit(int n, int i){
        int bitmask=~(1<<i);
        return n&bitmask; // Converts bits from 0 <-> 1
    }
    public static int UpdateithBit(int n, int i, int newBit){
        if (newBit==0){
            return ClearithBit(n,i);
        }
        else{
            return SetithBit(n,i);
        }
    }
    public static int ClearIbits(int n, int i){
        int bitmask=(~0)<<i;
        return n&bitmask;
    }
    public static int clearRangeBits(int n, int i, int j){
        int a=((~0)<<(j+1));
        int b=(1<<i)-1;
        int bitmask=a|b;
        return n & bitmask;
    }
}
