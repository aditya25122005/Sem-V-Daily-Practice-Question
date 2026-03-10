class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer [][][] dp= new Integer[m][n][maxMove+1];
        return Solve(startRow, startColumn, m,n, 0, maxMove,dp)%1000000007;
    }
    public static int Solve(int cr, int cc, int m, int n, int curr, int k,Integer [][][] dp){
        if(cr>=m || cc>=n || cr<0 || cc<0){
            if(curr<=k) return 1;
            return 0;
        }
        
        if(curr>k){
            return 0;
        }
        if(dp[cr][cc][curr]!=null) return dp[cr][cc][curr];
        int mod= 1000000007;
        long Path=0;
        Path+=Solve(cr+1,cc,m,n,curr+1,k,dp)%mod;
        Path+=Solve(cr-1,cc,m,n,curr+1,k,dp)%mod;
        Path+=Solve(cr,cc-1,m,n,curr+1,k,dp)%mod;
        Path+=Solve(cr,cc+1,m,n,curr+1,k,dp)%mod;

        return dp[cr][cc][curr] = (int)(Path%mod);


    }
}