package com.Questions;

public class Questions {
public static void main(String[] args){
    int arr[] = {3,2,4,5,6,7,2,2};
    int key = 2;
    AllOccourences(arr,key,0);
    DigitsInWords(1948);
    System.out.println();
    String str="Pushpraj";
    System.out.println(LengthOfString(str));
}
public static int AllOccourences(int arr[], int key, int i ){
    if (i==arr.length){
        return -1;
    }
    if (arr[i]==key){
        System.out.println(i);
    }
    return AllOccourences(arr,key,i+1);
}

public static void DigitsInWords(int digit){
    String digits[]={"Zero", "one ", "Two ", "Three", "Four", "five", "six",
    "seven", "eight", "nine"};
    if (digit==0){
        return;
    }
    int lastdigit=digit%10;
    DigitsInWords(digit/10);
    System.out.println(digits[lastdigit]);

}
public static int LengthOfString(String str){
    if (str.length()==0){
        return 0;
    }

    return LengthOfString(str.substring(1))+1;
}
}


