class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValid(board);
        
    }
    public static boolean isValid(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] != '.'){
                    char val=board[i][j];
                    board[i][j]='.';
                    if(!isSafe(board,val,i,j)){
                        return false;
                    }
                    board[i][j]=val;
                }
            }
        }
        return true;
    }
    public static boolean isSafe(char[][] board, char val, int row, int col){
        //check in col;
        for(int r=0;r<board.length;r++){
            if(board[r][col]==val){
                return false;
            }
        }
        //check in row
        for(int c=0;c<board[0].length;c++){
            if(board[row][c]==val){
                return false;
            }
        }
        //check Matrix
        int r=row - row%3;
        int c= col - col%3;
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