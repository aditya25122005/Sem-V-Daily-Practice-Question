class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length][2];
        for(int []A:dp){
            Arrays.fill(A,-1);
        }
        return Solve(prices,0,0,dp);
    }

    // prev ->0 Buy
    // prev ->1 Sell
    public static int Solve(int [] prices, int idx, int prev, int[][] dp){ 
        if(idx==prices.length){
            return 0;
        }
        if(dp[idx][prev]!=-1){
            return dp[idx][prev];
        }
        int a=0; 
        int b=0;
        int sell=0;
        int notSell=0;
        if(prev==0){// khareedo
        a= -prices[idx] + Solve(prices,idx+1,1,dp);
        b=Solve(prices,idx+1,0,dp); // Abhi bhi nahi kharida
        }
        if(prev==1){// Sell it
        sell = prices[idx]+Solve(prices,idx+1,0,dp);
        notSell= Solve(prices,idx+1,1,dp);
        }
        return dp[idx][prev] = Math.max(Math.max(a,b),Math.max(sell,notSell));
    }
}