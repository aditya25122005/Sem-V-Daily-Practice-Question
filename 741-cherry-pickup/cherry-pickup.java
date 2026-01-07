class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        Integer [][][] dp= new Integer[n][n][n];

        int ans= Solve(grid,0,0,0,dp);
        return ans==Integer.MIN_VALUE? 0 :ans;

    }
    public static int Solve(int[][] grid, int r1,int c1, int c2,Integer[][][] dp){
        int n=grid.length;
        // r1+c1== r2+c2
        int r2=r1+c1-c2;
        if(r1>=n || c1>=n || c2>=n || r2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }
        int maxCherry=0;
        int cherry= (r1==r2 && c1==c2)? grid[r1][c1] : grid[r1][c1]+grid[r2][c2];

        if(r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        if(dp[r1][c1][c2]!=null) return dp[r1][c1][c2];

        int A= Solve(grid,r1+1,c1,c2,dp);  // DD
        int B= Solve(grid,r1,c1+1,c2+1,dp);// RR
        int C= Solve(grid,r1+1,c1,c2+1,dp);// DR
        int D= Solve(grid,r1,c1+1,c2,dp);  // RD

        maxCherry=Math.max(Math.max(A,B),Math.max(C,D));
        if(maxCherry==Integer.MIN_VALUE){
            return dp[r1][c1][c2] = Integer.MIN_VALUE;
        }
        return dp[r1][c1][c2]=maxCherry+cherry;
    }
}