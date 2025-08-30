class Solution {
    static boolean solved=false;
    public void solveSudoku(char[][] board) {
        solved=false;
        solve(board,0,0);
    }
    public static void solve(char[][] board, int row ,int col){
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            solved=true;
            return;
        }
        if(board[row][col]!='.'){
          solve(board,row,col+1);
          return;
        }
        else{
            for(char val='1';val<='9';val++){
                if(issafe(board,row,col,val)){
                    board[row][col]=val;
                    solve(board,row,col+1);
                   if(solved) return;
                    board[row][col]='.';
                }
            }
        }
        
    }
    public static boolean issafe(char [][] board,int row, int col, char val){
        //check row
        
        for(int c=0;c<board.length;c++){
            if(board[row][c]==val){
                return false;
            }
        }
        //check column
        for(int r=0;r<board.length;r++){
            if(board[r][col]==val){
                return false;
            }
        }
        //check in Matrix;
        int r=row- row%3;
        int c= col-col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==val){
                    return false;
                }
            }
        }
        return true;

    }

}