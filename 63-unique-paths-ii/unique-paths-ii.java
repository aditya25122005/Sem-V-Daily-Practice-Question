class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n= obstacleGrid.length;
        int m= obstacleGrid[0].length;

        Integer[][] dp= new Integer[n][m];
        return Solve(obstacleGrid, 0,0,dp);
    }
    public static int Solve(int [][] grid, int cr, int cc ,Integer[][] dp){
        if(cr>= grid.length || cc>= grid[0].length || grid[cr][cc]==1){
            return 0;
        }
        if(cr==grid.length-1 && cc== grid[0].length-1){
            return 1;
        }
        if(dp[cr][cc]!= null) return dp[cr][cc];

        int A= Solve(grid, cr+1, cc,dp);
        int B= Solve(grid,cr,cc+1,dp);
        return dp[cr][cc] = A+B;
    }
}