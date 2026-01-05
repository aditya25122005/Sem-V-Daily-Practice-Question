class Solution {
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;
        boolean [][] visited= new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && board[i][j]=='O'){
                    // kardoChange=true;
                    Search(i,j,board);
                    
                    // if(kardoChange){
                    //     for(int r=0;r<n;r++){
                    //         for(int c=0;c<m;c++){
                    //             if(board[r][c]=='#') board[r][c]='X';
                    //         }
                    //     }
                    // }
                    // else{
                    //     for(int r=0;r<n;r++){
                    //         for(int c=0;c<m;c++){
                    //             if(board[r][c]=='#') board[r][c]='O';
                    //         }
                    //     }
                    // }

                }
            }
        }
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(board[r][c]=='#'){
                    board[r][c]='O';
                }
                else{
                    board[r][c]='X';
                }
            }
        }

    }
    // boolean kardoChange;
    public  void Search(int cr, int cc, char[][]board){
        if(cr<0 || cc<0 || cr>=board.length || cc>= board[0].length || board[cr][cc]=='#' ||board[cr][cc]=='X'){
            return;
        }
        // if((cr==0 || cc==0 || cr==board.length-1 || cc==board[0].length-1) && board[cr][cc]=='O' ){
        //     kardoChange=false;
        // }
        board[cr][cc]='#';

        Search(cr+1,cc,board);
        Search(cr-1,cc,board);
        Search(cr,cc-1,board);
        Search(cr,cc+1,board);
    }
}