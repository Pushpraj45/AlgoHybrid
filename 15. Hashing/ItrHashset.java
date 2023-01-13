import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class ItrHashset {
public static void main(String[] args){
    HashSet<String> cities  = new HashSet<>();
    cities.add("Delhi");
    cities.add("Mumbai");
    cities.add("Noida");
    cities.add("Bengaluru");

//    Iterator it= cities.iterator();
//    while (it.hasNext()){
//        System.out.println(it.next());
//    }

    for (String city : cities){
        System.out.println(city);
    }


    LinkedHashSet<String> lhs=new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("mumbai");
        lhs.add("chennai");
        lhs.add("Bengaluru");

        for (String str: lhs){
            System.out.println(str);
        }


    TreeSet<String> ts=new TreeSet<>();
        ts.add("Delhi");
        ts.add("Mumbai");
        ts.add("noida");
        ts.add("bengaluru");

    System.out.println(ts);
}
}
