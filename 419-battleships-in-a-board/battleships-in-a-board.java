class Solution {
    public int countBattleships(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='X'){
                    Solve(board,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void Solve(char[][] board, int cr, int cc){
        if(cr>=board.length || cc>=board[0].length || board[cr][cc]=='.'){
            return;
        }
        board[cr][cc]='.';
        Solve(board,cr+1,cc);
        Solve(board,cr,cc+1);

    }
}