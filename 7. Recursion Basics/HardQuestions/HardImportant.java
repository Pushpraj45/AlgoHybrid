package com.HardQuestions;

public class HardImportant {
    public static void main(String[] args){
        System.out.println(tillingProblem(4));
        String str="pushprajjj";
        RemoveDuplicates(str,0,new StringBuilder(""), new boolean [26]);
        System.out.println(FriendsPairing(5));
        BinaryStrings(4,0,"");
    }
    public static int tillingProblem(int n){  // 2xn (floor size)
//        Base case
        if (n==0||n==1){
            return 1;
        }
//        Kaam
//        Vertical choice
        int fnm1=tillingProblem(n-1);
//        Horizontal choice
        int fnm2=tillingProblem(n-2);

        int totalways=fnm1+fnm2;
        return totalways;
    }
    public static void RemoveDuplicates(String str, int index, StringBuilder newStr, boolean map[]){
        if (index==str.length()){
            System.out.println(newStr);
            return;
        }
        char Currchar=str.charAt(index);
        if (map[Currchar-'a']==true){
            // Duplicate
            RemoveDuplicates(str,index+1,newStr,map);
        }
        else {
            map[Currchar-'a']=true;
            RemoveDuplicates(str,index+1,newStr.append(Currchar),map);
        }
    }
    public static int FriendsPairing(int n){
        if (n==1||n==2){
            return n;
        }
//        Choice
//        Single
        int fnm1=FriendsPairing(n-1);

//        Pair
        int fnm2=FriendsPairing(n-2); // n se 2 log hat gaye
        int pairways=(n-1)*fnm2; // total n-1 choices hai un logo ke liye to pairup

        int totalWays=fnm1+pairways;
        return totalWays;
    }

//    Binary Strings Problem
    public static void BinaryStrings(int n, int lastplace, String str){
//        Base case
        if (n==0){ // n less hote hote 0 ho gaya
            System.out.println(str);
            return;
        }
//        Kaam
        BinaryStrings(n-1,0,str+"0"); // As ab humkko n-1 places fill karni hai to ye kara
        if (lastplace==0){
            BinaryStrings(n-1,1,str+"1");
        }
    }

}
