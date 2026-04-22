class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ll = new ArrayList<>();
        List<String> inner = new ArrayList<>();
        char [][] board = new char[n][n];
        for(char[] a: board) Arrays.fill(a,'.');
        Solve(ll,inner,n,board,0);
        return ll;


    }
    public static void Solve(List<List<String>> ll, List<String> inner, int Q, char[][] board,int row){
        if(Q==0){
            ll.add(construct(board));
            return;
        }
        if(row==board.length){
            return;
        }
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                Solve(ll,inner,Q-1,board,row+1);
                board[row][col] ='.';
            }
        }
    }
    public static List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<board.length;j++){
                sb.append(board[i][j]);
            }
            res.add(sb.toString());

        }
        return res;
    }
    public static boolean isSafe(char[][] board, int row, int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }
        for(int j=0;j<board.length;j++){
            if(board[row][j]=='Q'){
                return false;
            }
        }
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c--;
        }
        r = row-1;
        c = col+1;
        while(r>=0 && c<board.length){
            if(board[r][c]=='Q'){
                return false;
            }
            r--;
            c++;
        }
        return true;
    }
}