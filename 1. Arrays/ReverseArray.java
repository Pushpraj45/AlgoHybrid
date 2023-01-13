public class ReverseArray {
//    first and last index ko swap kar do
    public static void reverse(int arr[]){
        int first=0;
        int last = arr.length-1;

        while (first<last){
//            swap
            int temp = arr[last];
            arr[last]=arr[first];
            arr[first]=temp;

            first++;
            last--;
        }
    }
    public static void main(String[] args){

    }
}
