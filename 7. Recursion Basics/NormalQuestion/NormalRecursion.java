package com.NormalQuestion;
public class NormalRecursion {
    public static void main(String[] args){
        NumsInDecreasing(10);
        NumsInIncreasing(10);
        System.out.println(SumOfN(10));
        System.out.println(Factorial(5));
        System.out.println(NthFibonacci(6));

    }
    public static void NumsInDecreasing(int n){
        if (n==1){
            System.out.print(1);
            return;
        }
        System.out.print(n+"  ");
        NumsInDecreasing(n-1);

    }

    public static void NumsInIncreasing(int n){
        if (n==1){
            System.out.print(1);
            return;
        }
        NumsInIncreasing(n-1);
        System.out.print(n+"  ");

    }

    public static int Factorial(int n){
        if (n==0){
            return 1;
        }
        int fnm1=Factorial(n-1);
        int fn=n*fnm1;

        return fn;
    }
    public static int SumOfN(int n){
        if (n==1){
            return 1;
        }
        int snm1=SumOfN(n-1);
        int Sn=n+snm1;
        return Sn;
    }
    public static int NthFibonacci(int n){
        if (n==0||n==1){
            return n;
        }
        int fnm1=NthFibonacci(n-1);
        int fnm2=NthFibonacci(n-2);
        int fn=fnm1+fnm2;
        return fn;
    }

}
