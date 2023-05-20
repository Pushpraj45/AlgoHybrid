import java.util.HashMap;

public class ReconstructItieniery {
// Itinerary means journey usually we do this type of questions with the help of graphs. 
//     Tickets are always part of "from" and "to" so we have to find the place from where we can start our journey and end it at a required point. 
    public static String getStart(HashMap<String, String> tickets){
        
//         starting point -> for which from exist but to doesn't exist 
        HashMap<String, String> revMap=new HashMap<>();

        for (String key : tickets.keySet()){
            revMap.put(tickets.get(key), key); // value ki jagah key and vice versa
        }
// find a place jo to ke andar exist nahi karta hai by this logic
        for (String key : tickets.keySet()){
            if (!revMap.containsKey(key)){
                return key;  // starting point
            }
        }
        return null; //aisa case muskil hai aayega


    }
    public static void main(String[] args){
        HashMap<String, String> tickets=new HashMap<>();
//         If any other type of data structure is given convert it to maps and then solve 

        tickets.put("chennai", "bengaluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start=getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()){
//             Again start point se uski destination nikal li via iterating 
            System.out.print(" -> "+ tickets.get(start));
            start=tickets.get(start);
        }

    }
}
