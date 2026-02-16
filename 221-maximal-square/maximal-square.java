class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int n= matrix.length;
        int m= matrix[0].length;
        int [][] grid= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j]= matrix[i][j]-'0';
            }
        }
        Integer [][] dp= new Integer[n][m];
       
        Solve(grid,0,0,dp);
        int res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res=Math.max(res, dp[i][j]*dp[i][j]);
            }
        }
        return res;
    }
    public static int Solve(int [][] grid, int cr, int cc, Integer [][] dp){
        if(cr>=grid.length || cc>= grid[0].length){
            return 0;
        }
        if(dp[cr][cc]!=null){
            return dp[cr][cc];
        }
        int down= Solve(grid,cr+1,cc,dp);
        int right= Solve(grid,cr,cc+1,dp);
        int diag= Solve(grid,cr+1,cc+1,dp);
        if(grid[cr][cc]==0){
            return dp[cr][cc]=0;
        }

        return dp[cr][cc]= 1+ Math.min(down, Math.min(right,diag));
    }
}