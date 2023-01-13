import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public static void main(String[] args){
    int arr[]={1,2,3,2,5,1,1,1,2,2,3};
    HashMap<Integer, Integer> map= new HashMap<>();
    for(int i=0; i<arr.length; i++){
//        if (map.containsKey(arr[i])){
//            map.put(arr[i], map.get(arr[i])+1);
//        }
//        else{
//            map.put(arr[i],1);
//        }

//        More efficient way
        map.put(arr[i], map.getOrDefault(arr[i],0)+1);

    }

//        Set<Integer> KeySet=map.keySet(); // why do we need to store the things

        for (Integer key: map.keySet()){
            if (map.get(key)>arr.length/3){
                System.out.println(key);
            }
        }
}
}
