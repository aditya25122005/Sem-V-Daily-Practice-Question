class Solution {
    int ways;
    public int totalNQueens(int n) {
        ways=0;
        char[][] grid = new char[n][n];
        for(char[] c: grid){
            Arrays.fill(c,'.');
        }
        Solve(n,grid,0);
        return ways;
    }
     public void Solve(int Q, char[][] grid, int row){
        int n= grid.length;
        if(Q==0){
            ways++;
            return;
        }
        if(row==n){
            return;
        }
        for(int col=0;col<n;col++){
            if(isPossible(grid,row,col)){
                grid[row][col] = 'Q';
                Solve(Q-1,grid,row+1);
                grid[row][col] = '.';
            }
        }
    }
    public static boolean isPossible(char[][] grid, int r, int c){
        int n= grid.length;
        int row = r;
        int col = c;
        while(row>=0){
            if(grid[row][col]=='Q'){
                return false;
            }
            row--;
        }
        row=r;
        while(row>=0 && col>=0){
            if(grid[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }
        row=r;
        col=c;
        while(col<n && row>=0){
            if(grid[row][col]=='Q'){
                return false;
            }
            col++;
            row--;
        }
        return true;
    }
}