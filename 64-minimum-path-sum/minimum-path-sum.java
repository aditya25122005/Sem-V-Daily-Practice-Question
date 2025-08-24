class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp= new int[grid.length][grid[0].length];
        for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
        }
        }

    return Path_sum(grid, 0, 0,dp);
    }
    
    public static int Path_sum(int[][] grid, int cr, int cc, int [][] dp){
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return grid[cr][cc];
        }
        if(cr>=grid.length || cc>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }

        int right=Path_sum(grid, cr, cc+1,dp);
        int down=Path_sum(grid, cr+1, cc,dp);

        return dp[cr][cc]=Math.min(right,down)+grid[cr][cc];
    }
}