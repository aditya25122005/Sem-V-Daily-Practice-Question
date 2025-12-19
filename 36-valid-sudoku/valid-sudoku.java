class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch=board[i][j];
                if(ch!='.'){
                if(!isValid(board,i,j,ch)) return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int r, int c, char ch){
        
        for(int col=0;col<board[0].length;col++){
            if(board[r][col]==ch && col!=c) return false;
        }
        for(int row=0;row<board.length;row++){
            if(board[row][c]==ch && row!=r) return false;
        }
        int row= r-(r%3);
        int col= c-(c%3);
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(board[i][j]==ch && (i!=r && c!=j)) return false;
            }
        }
        return true;
    }
}