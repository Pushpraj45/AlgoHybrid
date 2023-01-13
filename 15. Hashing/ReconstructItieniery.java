import java.util.HashMap;

public class ReconstructItieniery {

    public static String getStart(HashMap<String, String> tickets){
        HashMap<String, String> revMap=new HashMap<>();

        for (String key : tickets.keySet()){
            revMap.put(tickets.get(key), key); // value ki jagah key and vice versa
        }

        for (String key : tickets.keySet()){
            if (!revMap.containsKey(key)){
                return key;  // starting point
            }
        }
        return null; //aisa case muskil hai aayega


    }
    public static void main(String[] args){
        HashMap<String, String> tickets=new HashMap<>();

        tickets.put("chennai", "bengaluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start=getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()){
            System.out.print(" -> "+ tickets.get(start));
            start=tickets.get(start);
        }

    }
}
