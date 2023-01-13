package com;
// Place Nqueens on an NxN chessboard such that no 2 queens can attack each other
public class Nquuenonesoln {
    public static void main(String[] args){
        int n=4;
        char board[][]=new char[n][n];
//        Initialize
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j]='x';
            }
        }

       if (Nqueens(board,0 )){
           System.out.println("Solution is possible ");
           PrintBoard(board);
       }
       else{
           System.out.println("Solution is not possible ");
       }
        System.out.println("Total no of ways "+count);
    }
    public static boolean issafe(char board[][], int row, int col){
//        Vertical up
        for (int i=row-1; i>=0; i--){
            if (board[i][col]=='Q'){
                return false;
            }
        }
//        Diag left up
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if (board[i][j]=='Q'){
                return false;
            }
        }
//        Diag Right up
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if (board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    static  int count=0;
    public static boolean Nqueens(char board[][], int row){

//        Base - Abhi keval rows ka dekh lete hai NQ in NR
        if (row==board.length){
//            PrintBoard(board);
            count++;
            return true;
        }
//        Column Loop
        for (int j=0; j<board.length; j++){
            if (issafe(board,row,j)){
                board[row][j]='Q';
               if (Nqueens(board,row+1)){
                   return true;
               }
                board[row][j]='x';  // BackTracking steps
            }
        }
return false;
    }
    public static void PrintBoard(char board[][]){
        System.out.println("-----Chess Board-----");
        for (int i=0; i<board.length; i++){
            for (int j=0; j< board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
