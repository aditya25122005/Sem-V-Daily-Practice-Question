class Solution {
    public int swimInWater(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        Integer [][][] dp= new Integer[n][m][n*n];


        boolean [][] visited= new boolean [n][m];
        
       return  Solve(grid,0,0,0,visited,dp);


    }
    
    public static int Solve(int [][] grid, int cr, int cc, int maxV,boolean[][] visited,Integer[][][] dp){
        if(cr<0 || cc<0 || cr>=grid.length || cc>= grid[0].length || visited[cr][cc]){
            return Integer.MAX_VALUE;
        }
        maxV=Math.max(maxV, grid[cr][cc]);
        if(cr==grid.length-1 && cc== grid[0].length-1){
            
            return maxV;
        }
        if(dp[cr][cc][maxV]!=null) return dp[cr][cc][maxV];

        visited[cr][cc] = true;
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,Solve(grid,cr-1,cc,maxV,visited,dp));
        ans=Math.min(ans,Solve(grid,cr+1,cc,maxV,visited,dp));
        ans=Math.min(ans,Solve(grid,cr,cc-1,maxV,visited,dp));
        ans=Math.min(ans,Solve(grid,cr,cc+1,maxV,visited,dp));

        visited[cr][cc]=false;

        return dp[cr][cc][maxV] = ans;



    }
}