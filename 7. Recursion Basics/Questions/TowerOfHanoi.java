package com.Questions;

public class TowerOfHanoi {
    public static void main(String[] args){
    int n=4;
    Towerofhanoi(n,"A","B","C");
    }

    public static void Towerofhanoi(int n, String src, String helper, String dest){
        if (n==1){
            System.out.println("Transfer disk "+n+" From "+src+" to "+dest);
            return;
        }
        // transfer top n-1 from src to helper using dest as 'helper'
            Towerofhanoi(n-1,src,dest,helper);
//        Transfer nth from src to dest
        System.out.println("transfer disk "+n+"from "+src+" to "+helper);
        //transfer n-1 from helper to dest using src as 'helper'
        Towerofhanoi(n-1, helper,src,dest);
    }
}
