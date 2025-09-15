class Solution {
    static boolean solved=false;
    public void solveSudoku(char[][] board) {
        solved=false;
        solve(board,0,0);
    }
    public static void solve(char[][] board, int row, int col){
        if(col==9){
            col=0;
            row++;
        }
        if(row==9){
            solved=true;
            return;
        }
        if(board[row][col]!='.'){
            solve(board,row,col+1);
            return;
        }else{
            for(char ch='1';ch<='9';ch++){
                if(isValid(board, row, col, ch)){
                    board[row][col]=ch;
                    solve(board,row,col+1);
                    if(solved) return;
                    board[row][col]='.';
                }
            }
        }
    }
    public static boolean isValid(char[][] board, int row, int col, char ch){
        // check col
        for(int i=0;i<board.length;i++){
            if(board[i][col]==ch){
                return false;
            }
        }
        // check row
        for(int i=0;i<board.length;i++){
            if(board[row][i]==ch){
                return false;
            }
        }
        // check box
        int r= row- row%3;
        int c= col- col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
}