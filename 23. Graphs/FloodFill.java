public class FloodFill {


        public static void helper(int[][] image, int sr , int sc, int color, boolean vis[][], int orgcolor)   {
            if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc]!=orgcolor){
                return;
            }

            image[sr][sc]=color;
            // left
            helper(image, sr, sc-1, color, vis, orgcolor);
            // right
            helper(image, sr, sc+1, color, vis, orgcolor);
            // up
            helper(image, sr-1, sc, color, vis, orgcolor);
            // down
            helper(image, sr+1, sc, color, vis, orgcolor);

        }
        public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
            boolean vis[][]=new boolean [image.length][image[0].length];
            if(image[sr][sc]!=color)

                helper(image, sr, sc, color, vis, image[sr][sc]);
            return image;
        }



// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         if(image[sr][sc]!=newColor)
//         dfs(image,sr,sc,newColor,image[sr][sc]);
//         return image;
//     }
//     public void dfs(int[][] image,int x,int y,int newColor,int s)
//     {
//         if(x<0||y<0||y>=image[0].length||x>=image.length||image[x][y]!=s)
//             return;
//         image[x][y]=newColor;
//         dfs(image,x+1,y,newColor,s);
//         dfs(image,x-1,y,newColor,s);
//         dfs(image,x,y+1,newColor,s);
//         dfs(image,x,y-1,newColor,s);
//     }
// }
    public static void main(String[] args){
        int[][] image={{1,1,1},{1,1,0},{1,0,1}};
        int sr =1, sc=1, color=2;
        System.out.println(floodFill(image,sr,sc,color));

    }
}

