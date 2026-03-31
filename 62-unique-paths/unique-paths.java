class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] dp= new Integer[m][n];
        return Solve(0,0,m,n,dp);
    }

    public static int Solve(int cr, int cc, int n, int m,Integer[][] dp){
        if(cr>=n || cc>=m){
            return 0;
        }
        if(cr==n-1 && cc==m-1){
            return 1;
        }
        if(dp[cr][cc] != null)  return dp[cr][cc];
        int A=0;
        int B=0;
        A=Solve(cr+1,cc,n,m,dp);
        B=Solve(cr,cc+1,n,m,dp);
        return dp[cr][cc] = A+B;

    }
}