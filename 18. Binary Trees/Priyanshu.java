import java.util.Scanner;

public class Priyanshu {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter five numbers ");

        int arr[]={sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt()};

        for (int i=arr.length-1; i>=0; i--){
            System.out.print(arr[i]+" ");
        }
    }
}
