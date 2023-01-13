public class SearchInSortedMatrix {
    public static void main(String[] args){
        int matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int key = 33;
        StairCase(matrix,key);
    }

    public static boolean StairCase(int matrix[][], int key){  // O(n+m)
        int n=matrix.length, m=matrix[0].length;
        int i=0,  j= n-1;
        while (j>=0 && i<n){
            if (matrix[i][j]==key){
                System.out.print("Found at ("+i+","+j+")");
                return true;
            }
//            go down
            else if (matrix[i][j]<key){
                i++;
            }
//            go left
            else if (matrix[i][j]>key){
                j--;
            }
        }
        System.out.println("Not found");
        return false;
    }
}
