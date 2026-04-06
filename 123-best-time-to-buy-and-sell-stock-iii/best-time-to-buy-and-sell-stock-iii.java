class Solution {
    public int maxProfit(int[] prices) {


        int[][][] dp= new int[prices.length][3][2];
        for(int[][] A: dp){
            for (int[] d: A) Arrays.fill(d,-1);
        }
        return Solve(prices, 0, 0, 0, dp);
        // 0-> buy
        // 1 -> sell

    }
    public static int Solve(int [] prices, int idx, int Ct, int prev, int [][][] dp){
        
        if(idx==prices.length && Ct<=2){
            return 0;
        }
        if(dp[idx][Ct][prev] !=-1) return dp[idx][Ct][prev];
        int A=0;
        int B=0;
        int C=0;
        int D=0;
        if(prev==0){
            if(Ct<2)
            A = - prices[idx] + Solve(prices, idx+1, Ct+1, 1,dp);
            B = Solve(prices,idx+1,Ct,0,dp);
        }
        else{
            C = prices[idx] + Solve(prices, idx+1, Ct, 0,dp);
            D = Solve(prices,idx+1,Ct,1,dp);
        }

        return dp[idx][Ct][prev] = Math.max(Math.max(A,B),Math.max(C,D));
    }
}