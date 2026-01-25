class Solution {
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        int r=0;
        for(int j=0;j<m;j++){
            if(board[r][j]=='O'){
                DFS(board,r,j);
            }
        }
        r= n-1;
        for(int j=0;j<m;j++){
            if(board[r][j]=='O'){
                DFS(board,r,j);
            }
        }
        int c=0;
        for(r=0;r<n;r++){
            if(board[r][c]=='O'){
                DFS(board,r,c);
            }
        }
        c=m-1;
        for(r=0;r<n;r++){
            if(board[r][c]=='O'){
                DFS(board,r,c);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }

    }
    public static void DFS(char[][] board, int cr, int cc){
        if(cr<0 || cc<0 || cr>= board.length || cc>= board[0].length || board[cr][cc]=='X' || board[cr][cc]=='#'){
            return;
        }
            board[cr][cc]='#';

            DFS(board,cr+1,cc);
            DFS(board,cr-1,cc);
            DFS(board,cr,cc+1);
            DFS(board,cr,cc-1);
        
    }
}