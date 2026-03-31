class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp= new Integer[amount+1][coins.length];
        int res = Solve(coins, amount,0,dp);
        return res==Integer.MAX_VALUE? -1: res;
    }
    public static int Solve(int [] coins, int amt, int idx,Integer[][] dp){
        if(idx>=coins.length){
            if(amt==0){
            return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(amt<0){
            return Integer.MAX_VALUE;
        }
        if(amt==0){
            return 0;
        }
        if(dp[amt][idx] != null) return dp[amt][idx];


        int A=Integer.MAX_VALUE;
        int B=Integer.MAX_VALUE;
        int next= Solve(coins, amt- coins[idx], idx,dp);
        if(next!=Integer.MAX_VALUE){
            A= 1+ next;
        }
        B= Solve(coins, amt,idx+1,dp);
        return dp[amt][idx] = Math.min(A,B);
    }
}