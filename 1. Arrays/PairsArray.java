public class PairsArray {
//    nested loop for each element
     public static void PrintPairs(int arr[]){
         int tp=0;
         for (int i=0; i<arr.length; i++){
             int curr=arr[i];  //O(n^2)
             for (int j=i+1; j<arr.length; j++){
                 System.out.println("("+curr+","+arr[j]+") ");
                 tp++;
             }
             System.out.println();
         }
         System.out.println("total number of pairs "+tp);
     }
}

//Formula for calculating total number of pairs = n(n-1)/2
