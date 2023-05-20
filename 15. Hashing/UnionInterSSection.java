import java.util.HashSet;

public class UnionInterSSection {
    public static void main(String[] args){
        int arr1[]={7,3,9};
        int arr2[]={6,3,9,2,9,4};

        HashSet<Integer> set=new HashSet<>();

//        union
        for (int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        for (int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        
//         To print the elements we can iterate in set amd print all elements 

        System.out.println("union = "+set.size());

//        intersection
        set.clear();

        for (int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }

        int count=0;

        for (int i=0; i<arr2.length; i++){
            if (set.contains(arr2[i])){
                count++;
//                 Here we can directly print elements or we can just add them in another set simultaneuosly can remove also 
                set.remove(arr2[i]);
            }
        }
        System.out.println("intersection = "+count);

    }
}
