class Solution {
    public int maxSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int ans=0;


        for(int sr=0;sr+3<=n;sr++){
            for(int sc=0;sc+3<=m;sc++){
                ans=Math.max(ans,Solve(grid,sr,sr+2,sc,sc+2));
            }
        }
        return ans;
    }
    public static int Solve(int[][] grid, int sr, int er, int sc, int ec){
        int sum=0;
        for(int j=sc;j<=ec;j++){
            sum+= grid[sr][j];
        }
        for(int j=sc;j<=ec;j++){
            sum+= grid[er][j];
        }
        sum+= grid[sr+1][sc+1];
        return sum;
    }
}