package com.basics;

public class Questions {
    public static void main(String[] args){
        swap(3,4);
        AddOne(8);
//        CaseConverter("PUSHPRAJ");
    }

//    Question- 1
    public static void swap (int x, int y){
        System.out.println("Before swapping the value of variables are "+x+","+y);
//        Swap using XOR -
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println("After swapping the value of variables are "+x+","+y);
    }

//    Question- 2
    public static void AddOne(int n){
        System.out.println(n+"+"+1+" = "+-~n);
//        as we know
//        -x = ~x + 1
//        -~x = x + 1 replaced x by ~x
    }

//    Question- 3
//    public static void CaseConverter{
//        for (char ch='A'; ch<='Z';  ch++){
//            System.out.println((char) (ch|' '));
//        }
//    }

}
