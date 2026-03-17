class Solution {
    public static void solve(char [][] board){
        // har ek border wali row/col se start karo aur agar vaha O hai to # mark kardo aur DFS chala do
        // Jaha Jaha # hai waha wapas O mark kardo 
        // Baki Jagah X mark kardo
        int n= board.length;
        int m= board[0].length;
        int r=0;
        for(int j=0;j<m;j++){
            if(board[r][j]=='O'){
                DFS(board,r,j);
            }
        }

        r = n-1;
        for(int j=0;j<m;j++){
            if(board[r][j]=='O'){
                DFS(board,r,j);
            }
        }

        int c=0;
        for(int i=0;i<n;i++){
            if(board[i][c]=='O'){
                DFS(board,i,c);
            }
        }

        c=m-1;
        for(int i=0;i<n;i++){
            if(board[i][c]=='O'){
                DFS(board,i,c);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
                else{
                    board[i][j]='X';
                }
            }
        }


    }
    public static void DFS(char [][] board, int cr, int cc){
        if(cr<0 || cc<0 || cr>=board.length || cc>= board[0].length || board[cr][cc]!='O'){
            return;
        }
        board[cr][cc]='#';
        DFS(board,cr-1,cc);
        DFS(board,cr,cc-1);
        DFS(board,cr,cc+1);
        DFS(board,cr+1,cc);
    }

}