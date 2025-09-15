class Solution {
    public int minPathSum(int[][] grid) {
        int [][] dp= new int[grid.length][grid[0].length];
        for(int []a :dp){
            Arrays.fill(a,-1);
        }
        return Solve(grid,0,0,dp);
    }
    public static int Solve(int [][] grid, int cr, int cc, int[][]dp){
        if(cr>=grid.length || cc>=grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return grid[cr][cc];
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }

        int ans=0;
        int f=Solve(grid,cr,cc+1,dp);
        int s=Solve(grid,cr+1,cc,dp);
        ans+=Math.min(f,s);

        return dp[cr][cc]=ans+grid[cr][cc];
    }
}