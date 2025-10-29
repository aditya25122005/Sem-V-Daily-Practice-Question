class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp= new int[amount+1][coins.length];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        int res=Solve(coins,amount,0,dp);
        if(res==Integer.MAX_VALUE){
            return -1;
        }else{
            return res;
        }
    }
    public static int Solve(int [] coins, int amount, int idx, int[][]dp){
        if(idx==coins.length){
            return Integer.MAX_VALUE;
        }
        if(amount==0){
            return 0;
        }
        if(dp[amount][idx]!=-1){
            return dp[amount][idx];
        }
        int a=Integer.MAX_VALUE;
        int b=Integer.MAX_VALUE;
        if(amount>=coins[idx]){
            int ans=Solve(coins,amount-coins[idx],idx,dp);
            if(ans!=Integer.MAX_VALUE){
                a=1+ans;
            }
        }
        b=Solve(coins,amount,idx+1,dp);

        return dp[amount][idx] = Math.min(a,b);
        

       
    }
}