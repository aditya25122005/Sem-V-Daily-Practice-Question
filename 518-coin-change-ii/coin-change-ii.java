class Solution {
    public int change(int amount, int[] coins) {
        int [][] dp= new int[amount+1][coins.length];
        for(int i=0;i<dp.length;i++){
        for(int j=0;j<dp[0].length;j++){
            dp[i][j]=-1;
            }    
        }
        return Coin_Change(coins,0,amount,dp);
    }
    public int Coin_Change(int[] coins,int i, int amount, int[][] dp){
        if(amount==0){
            return 1;
        }
        if(i==coins.length){
            return 0;
        }
        if(dp[amount][i]!=-1){
            return dp[amount][i];
        }
        int inc=0;
        int exc=0;
        if(amount>=coins[i]){
            inc=Coin_Change(coins, i, amount-coins[i],dp);
        }
        exc=Coin_Change(coins, i+1, amount,dp);
        return dp[amount][i]=inc+exc;
    }
}    