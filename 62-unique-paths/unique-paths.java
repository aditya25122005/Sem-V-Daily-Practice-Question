class Solution {
    int count;
    public int uniquePaths(int m, int n) {
        count=0;
        int [] [] arr= new int[m][n];
        int[][] dp= new int[m][n];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(arr,0,0,m,n,dp);
        // return count;
    }
    public int solve(int[][]arr, int cr, int cc, int m, int n, int[][] dp){
        if(cr>=m || cc>=n){
            return 0;
        }
        if(cr==m-1 && cc==n-1){
            return 1;
        }
        if(dp[cr][cc]!=-1) return dp[cr][cc];
        int path=0;
        int f=solve(arr,cr+1,cc,m,n,dp);
        int s=solve(arr,cr,cc+1,m,n,dp);
        path=f+s;
        return dp[cr][cc]=path;
        
    }
}