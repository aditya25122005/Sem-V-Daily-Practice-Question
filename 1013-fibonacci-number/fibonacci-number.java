class Solution {
    
    public int fib(int n) {
        Integer[] dp= new Integer[n+1];
        return Solve(n,dp);

    }
    public static int Solve(int n, Integer[] dp){ 
        if(n==0 || n==1){
            return n;
        }
        if(dp[n] != null) return dp[n];
        return dp[n]= Solve(n-1,dp)+Solve(n-2,dp);
    }
}