class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int [][] dp= new int[arr.length][arr[0].length];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return Paths(arr,0,0,dp);
    }
    public static int Paths(int [][] grid, int cr, int cc, int [][]dp){
        if(cc>=grid[0].length || cr>=grid.length){
            return 0;
        }
        if(grid[cr][cc]==1){
            return 0;
        }
        if(cr==grid.length-1 && cc==grid[0].length-1){
            return 1;
        }
        if(dp[cr][cc]!=-1){
            return dp[cr][cc];
        }

        int a=Paths(grid,cr,cc+1,dp);
        int b=Paths(grid,cr+1,cc,dp);
        return dp[cr][cc]=a+b;
        

    }
}