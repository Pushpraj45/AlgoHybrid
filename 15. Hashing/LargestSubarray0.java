import java.util.HashMap;

public class LargestSubarray0 {

    public static void main(String[] args){
        int arr[]={15,-2,2,-8,1,7,10,23};

        HashMap<Integer, Integer> map=new HashMap<>();

        int sum=0;
        int len=0;
        
//         sum[i+1,j] => sum[0,j] - sum[0,i];
//         got the formula 0 =>  sum[j] - sum[i];  

        for (int j=0; j<arr.length; j++){
            sum+=arr[j]; // sum till jth index 
//             if sum is their in map just compare if matched add length in answer and start comparing 
//             else add sum in map with thier index 
            if (map.containsKey(sum)){ 
                // agar koi sum exist karta hai so that simply implies ki un dono ke beech mein koi subarray hai jiska sum 0 hai 
                len=Math.max(len, j-map.get(sum));
            }
            else{
                map.put(sum,j);
            }
        }
        System.out.println("largets subarray with sum as 0 => "+len);
    }
}
