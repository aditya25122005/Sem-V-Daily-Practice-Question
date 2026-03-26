class Solution {
    public int climbStairs(int n) {
        int [] dp= new int[n];
        Arrays.fill(dp,-1);
        return Solve(0,n,dp);
    }
    public static int Solve(int idx, int n, int [] dp){
        if(idx>n){
            return 0;
        }
        if(idx==n){
            return 1;
        }
        if(dp[idx]!=-1) return dp[idx];
        int A= Solve(idx+1,n,dp);
        int B= Solve(idx+2,n,dp);
        return dp[idx] = A+B;
    }
}