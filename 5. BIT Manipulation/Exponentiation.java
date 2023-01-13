package com.basics;

public class Exponentiation {
    public static void main(String[] args){
        int a=3;
        int n=5;
        int ans=1;
        while(n>0){
            if ((n & 1)!=0){ //Check LSB
                ans=ans*a;
            }
            a=a*a; // Updation of our number
            n=n>>1; // Performed right shift for checking Bit is 1 or not
        }
        System.out.println("Answer is "+ans);

    }
}
