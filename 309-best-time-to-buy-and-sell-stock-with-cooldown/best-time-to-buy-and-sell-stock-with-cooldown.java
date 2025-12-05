class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp= new int[prices.length][2];
        for(int A []:dp){
            Arrays.fill(A,-9999999);
        }

        return Solve(prices,0,0,dp);
    }
    public int Solve(int[] arr, int idx, int prev, int[][] dp){
        if(idx>=arr.length){
            return 0;
        }
        if(dp[idx][prev]!=-9999999){
            return dp[idx][prev];
        }
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        //Buy
        if(prev==0){
        a=-arr[idx]+ Solve(arr,idx,1,dp);
        b=Solve(arr,idx+1,0,dp);
        }
        else{
            c=arr[idx]+Solve(arr,idx+2,0,dp);
            d=Solve(arr,idx+1,1,dp);
        }
        return dp[idx][prev] = Math.max(Math.max(a,b),Math.max(c,d));


    }
}