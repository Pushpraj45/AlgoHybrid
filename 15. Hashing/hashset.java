import java.util.HashSet;

public class hashset {
    public static void main(String[] args){
        HashSet<Integer> set=new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(3);
        set.add(2);

        System.out.println(set);
        System.out.println(set.size());
        set.clear();
        set.isEmpty();
        if (set.contains(2)){
            System.out.println("it contains ");
        }
        else{
            System.out.println("it does not contains ");
        }
    }
}
