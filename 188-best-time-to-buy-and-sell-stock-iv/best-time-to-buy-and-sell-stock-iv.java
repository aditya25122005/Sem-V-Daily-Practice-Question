class Solution {
    public int maxProfit(int k, int[] prices) {
        int N= prices.length;
        int [][][] dp= new int[N+1][k+1][2];
        for(int [][] A:dp){
            for(int []a:A){
                Arrays.fill(a,-1);
            }
        }
        return Solve(prices,0,k,1,dp);
    }
    public static int Solve(int[] prices, int idx, int trans, int buy, int[][][] dp){
        if(trans==0 || idx==prices.length){
            return 0;
        }
        if(dp[idx][trans][buy]!=-1){
            return dp[idx][trans][buy];
        }
        if(buy==1){
            return dp[idx][trans][buy] = Math.max(-prices[idx]+Solve(prices,idx+1,trans,0,dp),
            Solve(prices,idx+1,trans,1,dp));
        }else{
            return dp[idx][trans][buy] = Math.max(prices[idx]+Solve(prices,idx+1,trans-1,1,dp),
            Solve(prices,idx+1,trans,0,dp));
        }
    }
}