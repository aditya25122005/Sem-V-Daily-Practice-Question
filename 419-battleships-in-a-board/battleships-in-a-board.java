class Solution {
    public int countBattleships(char[][] board) {
        int c=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='X'){
                    c++;
                    count(board,i,j);
                }
            }
        }
        return c;
    }
    public static void count(char[][]board, int cr, int cc){
        if(cr<0 || cr>= board.length || cc<0 || cc>=board[0].length || board[cr][cc]=='.'){
            return;
        }
        board[cr][cc]='.';
        count(board,cr+1,cc);
        count(board,cr-1,cc);
        count(board,cr,cc-1);
        count(board,cr,cc+1);
    }
}