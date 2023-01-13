package com.basics;

public class PowerOftwo {
    public static void main(String[] args){
        int n=16;
        if ((n&(n-1))==0){
            System.out.println("Number is power of 2 ");
        }
        else{
            System.out.println("false ");
        }
    }
}
