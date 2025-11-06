class Solution {
    public int climbStairs(int n) {
        int[] dp= new int[n+1];
        Arrays.fill(dp,-1);
        return Solve(0,n,dp);
    }
    public static int Solve(int idx, int n, int [] dp){
        if(idx>n){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }

        if(idx==n){
            return 1;
        }
        
        int a = Solve(idx+2,n,dp);
        int b = Solve(idx+1,n,dp);

        return dp[idx] = a+b;



    }
}