import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args){
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

//        Suppose activities are not sorted in end part then the process of sorting
        int activities[][]= new int[start.length][3];
        for (int i=0; i< start.length; i++){
            activities[i][0]=i; // index indentification
            activities[i][1]=start[i]; // start time 
            activities[i][2]=end[i]; // end time 
        }
        
//         same we have written in next lines for these 
//        sorting of 2d arrays
//        lambda function-> short form arrow function
        Arrays.sort(activities, Comparator.comparingDouble(o->o[2])); // start time basis = o->o[1] 

//        end time basis sorted
        int maxact=0;
        ArrayList<Integer> ans=new ArrayList<>();

//        1st Activity
        maxact=1;
        ans.add(activities[0][0]);
        int lastEnd=end[activities[0][2]];
        for (int i=1; i<end.length; i++){
            if (activities[i][1]>=lastEnd){
//                Activity select
                maxact++;
                ans.add(activities[i][0]);
                lastEnd=activities[i][2];
            }
        }
        System.out.println("max activities = "+ maxact);
        for (int i=0; i<ans.size(); i++){
            System.out.print("A"+ans.get(i));
        }
        System.out.println();
    }
}
