import java.util.HashMap;
import java.util.Set;

public class Creation {
    public static void main(String[] args){
        HashMap<String , Integer> hm=new HashMap<>();

//        Insert
        hm.put("India",100);
        hm.put("Aus",120);
        hm.put("Indonesia",130);

 /*       System.out.print(hm); printing the hashmap 

/        get
        System.out.print(hm.get("India"));

//        containsKey
        System.out.println(hm.containsKey("Zim"));

//        remove
        System.out.println(hm.remove("India"));

//        size
        System.out.println(hm.size());

//        clear
        hm.clear();

//        isEmpty
        System.out.println(hm.isEmpty());


  */

//        Iterate
//        entrySet
        Set<String> keys=hm.keySet();
        System.out.println(keys);

        for (String k :  keys){
            System.out.println("key="+k+ ",value="+hm.get(k));
        }
    }
}
