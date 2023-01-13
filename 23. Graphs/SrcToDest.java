import java.util.ArrayList;

public class SrcToDest {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void printAllPath(ArrayList<Edge>[] graph, int src, int dest, String path){
        if (src==dest){
            System.out.println(path+dest);
            return;
        }
        for (int i=0; i<graph[src].size(); i++){
            Edge e=graph[src].get(i);
            printAllPath(graph,e.dest,dest,path+src);
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge (5,0));
        graph[5].add(new Edge (5,2));

    }

    public static void main(String[] args){
        int V=6;
        ArrayList<Edge>[] graph =new ArrayList[V];
        createGraph(graph);
        int src=5;
        int path=1;

        printAllPath(graph,src,1,"");
    }
}

//class Solution {
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(graph.length == 0 || graph[0].length == 0)
//            return res;
//
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        dfs(graph,res,list,0);
//
//        return res;
//    }
//
//    public void dfs(int[][] graph,List<List<Integer>> res,List<Integer> list,int pos){
//        if(pos == graph.length - 1){
//            res.add(new ArrayList<>(list));
//        }else{
//            for(int d:graph[pos]){
//                list.add(d);
//                dfs(graph,res,list,d);
//                list.remove(list.size()-1);
//            }
//        }
//    }
//}

//class Solution {
//    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        List<List<Integer>> ans = new ArrayList<>();
//        List<Integer> res = new ArrayList<>();
//        res.add(0);
//        dfs(ans,res,graph.length - 1 , 0 , graph);
//        return ans;
//    }
//
//    private void dfs(List<List<Integer>>ans,List<Integer>res ,int target ,int source ,int[][]graph){
//        if(target == source){
//            ans.add(new ArrayList<>(res));
//            return;
//        }
//
//        for(int nei : graph[source]){
//            res.add(nei);
//            dfs(ans,res,target,nei,graph);
//            res.remove(res.size() - 1);
//        }
//
//    }
//}