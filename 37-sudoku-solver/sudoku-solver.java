class Solution {
    public void solveSudoku(char[][] board) {
        Solve(board,0,0);
    }
    public static boolean Solve(char[][]board, int r, int c){
        if(c==9){
            c=0;
            r++;
        }
        if(r==9){
            return true;
        }
        if(board[r][c]!='.'){
            return Solve(board,r,c+1);
        }
        else{
            for(char ch='1';ch<='9';ch++){
                if(isPossible(board,r,c,ch)){
                    board[r][c]=ch;
                    if(Solve(board,r,c+1)) return true;
                    board[r][c]='.';
                }
            }
        }
        return false;
    }
    public static boolean isPossible(char[][] board, int row, int col,char ch){
        for(int c=0;c<board[0].length;c++){
            if(board[row][c]==ch) return false;
        }
        for(int r=0;r<board.length;r++){
            if(board[r][col]==ch) return false;
        }
        int r= row-(row%3);
        int c= col-(col%3);
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