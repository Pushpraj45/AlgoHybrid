public class SubarrayasPrinting {
//    ek number lo aur dusra lo uske beech ke sab element print kar do
//    3 loops -> start -> end -> start to end
    public static void print(int arr[]){
        int ts=0;
        for (int i=0; i<arr.length; i++){
            int start=i;
            for (int j=i; j<arr.length; j++){
                int end=j;
                for (int k=start; k<=end; k++){
                    System.out.print(arr[k]+" "); //subarray
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total Subarrays "+ts);  // n(n+1)/2
    }
    public static void main(String[] args){

    }
}
