import java.util.ArrayList;
import java.util.List;

public class CourseScheduleI {
    class Solution {

        List<List<Integer>> graph;

        void init_graph(int v){
            graph = new ArrayList<>();
            for(int i=0;i<v;i++)
                graph.add(new ArrayList<>());
        }

        boolean isLoop(int u, boolean[]vis, boolean[]stack){
            vis[u] = true;
            stack[u] = true;
            for(int v : graph.get(u)){
                if(vis[v] && stack[v]) return true;
                if(!vis[v] && (isLoop(v,vis,stack))) return true;
            }
            stack[u] = false;
            return false;
        }

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int v = numCourses;
            init_graph(v);
            for(int i=0;i<prerequisites.length;i++){
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }

            boolean[] vis = new boolean[v];
            boolean[] stack = new boolean[v];

            for(int i=0;i<v;i++){
                if(!vis[i] && isLoop(i,vis,stack)) return false;
            }
            return true;
        }
    }
}
