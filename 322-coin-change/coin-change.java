class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp= new int[amount+1];
        
        Arrays.fill(dp,-1);
        int ans=solve(coins,amount,dp);
        return (ans==Integer.MAX_VALUE)? -1:ans;

    }
    public static int solve(int[] coin, int amt, int[] dp){
        if(amt==0){
            return 0; // need 0 coins
        }
        if(amt<0){
            return Integer.MAX_VALUE; //
        }
        if(dp[amt]!=-1) {
            return dp[amt];
        }
        int min_ans=Integer.MAX_VALUE;
        for(int i=0;i<coin.length;i++){
            int curr=solve(coin,amt-coin[i],dp);
            if(curr!=Integer.MAX_VALUE){
                min_ans=Math.min(min_ans,1+curr);
            }
        }
        return dp[amt]=min_ans;
        
    }
}