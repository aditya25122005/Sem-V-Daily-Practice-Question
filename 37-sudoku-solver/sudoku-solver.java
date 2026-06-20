class Solution {
    public void solveSudoku(char[][] board) {
        Solve(board,0,0);
    }
    public boolean Solve(char[][] board, int row, int col){
       
        if(col==9){
            row++;
            col=0;
        }
        if(row==9){
            return true;
        }
    
        if(board[row][col]!='.'){
           return Solve(board,row,col+1);
        }
        else{
            for(char ch ='1'; ch<='9'; ch++){
                if(isPossible(board,row,col,ch)){
                    board[row][col]=ch;
                    if(Solve(board,row,col+1)) return true;
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }
    public static boolean isPossible(char[][] board, int row, int col, char ch){
        for(int c = 0;c<9;c++){
            if(board[row][c]==ch) return false;
        }
        for(int r=0;r<9;r++){
            if(board[r][col]==ch) return false;
        }

        int r  = row - (row%3);
        int c = col -(col%3);
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j]==ch) return false;
            }
        }
        return true;
    }
}