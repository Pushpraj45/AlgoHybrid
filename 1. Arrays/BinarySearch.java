public class BinarySearch {
    public static void main(String[] args){

    }
    public static int BinarySearch(int numbers[], int key){
        int start=0;
        int end=numbers.length-1;

        while (start<=end){
            int mid =(start+end)/2; 
//             to avoid 
 
            if (numbers[mid]==key){
                return mid;
            }
            if (numbers[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}
