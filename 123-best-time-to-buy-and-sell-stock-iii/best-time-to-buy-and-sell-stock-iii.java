class Solution {
    public int maxProfit(int[] prices) {
        int N= prices.length;
        int[][][] dp= new int[N+1][3][2];
        for(int [][] inner:dp){
            for(int[]a:inner){
            Arrays.fill(a,-1);
            }
        }
        return Solve(prices,0,2,1,dp);

    }
    // buy-->1
    // sell-->0
    public static int Solve(int[]prices,int idx, int trans,int buy,int[][][]dp){
        if(trans==0 || idx==prices.length){
            return 0;
        }
        if(dp[idx][trans][buy]!=-1){
            return dp[idx][trans][buy];
        }
        if(buy!=0){ //ie buy==1 -> We have to buy
    //Ye humne kharcha kiya   // Ye jo hume future me profit hoga
           return dp[idx][trans][buy]= Math.max(-prices[idx] + Solve(prices,idx+1,trans,0,dp),// This Total is Profit

           Solve(prices,idx+1,trans,1,dp)); // Skipping and buy later
        }
        else{ // Sell
        return dp[idx][trans][buy]= Math.max(prices[idx]+Solve(prices,idx+1,trans-1,1,dp),
            Solve(prices,idx+1,trans,0,dp));
        }

    }
}