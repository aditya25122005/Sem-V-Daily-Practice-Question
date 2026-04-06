class Solution {
    public int maxProfit(int[] prices, int fee) {
        int [][] dp= new int[prices.length][2];
        for(int [] A: dp){
            Arrays.fill(A,-1);
        }
        return Solve(prices,fee,0,0,dp);
    }
    public static int Solve(int [] prices, int Fees, int idx, int prev,int [][] dp){
        if(idx==prices.length){
            return 0;
        }
        if(dp[idx][prev] != -1) return dp[idx][prev];
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        if(prev==0){
            A = -prices[idx]-Fees+ Solve(prices,Fees, idx+1,1,dp);
            B= Solve(prices,Fees, idx+1, 0,dp);
        }
        else{
            C = prices[idx] + Solve(prices,Fees, idx+1,0,dp);
            D = Solve(prices, Fees, idx+1,1,dp);
        }
        return dp[idx][prev] = Math.max(Math.max(A,B),Math.max(C,D));
    }
}