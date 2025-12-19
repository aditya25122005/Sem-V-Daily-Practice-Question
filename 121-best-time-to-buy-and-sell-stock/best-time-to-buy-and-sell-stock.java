class Solution {
    public int maxProfit(int[] prices) {
        // int [][] dp= new int[prices.length][2];
        // for(int []D:dp) Arrays.fill(D,-1);
        // return Solve(prices,0,0,0,dp);
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        for(int num:prices){
            if(num<minPrice)minPrice=num;
            else maxProfit=Math.max(maxProfit,num-minPrice);
        }
        return maxProfit;
    }
    // public static int Solve(int[] arr, int idx, int prev, int count, int[][]dp){
    //     if(count==1){
    //         return 0;
    //     }
    //     if(idx==arr.length){
    //         return 0;
    //     }
    //     if(dp[idx][prev]!=-1) return dp[idx][prev];

    //     int a=0;
    //     int b=0;
    //     int c=0;
    //     int d=0;

    //     if(prev==0){
    //         a=-arr[idx]+Solve(arr,idx+1,1,count,dp);
    //         b=Solve(arr,idx+1,0,count,dp);
    //     }
    //     else{
    //         c=arr[idx]+Solve(arr,idx+1,0,count+1,dp);
    //         d=Solve(arr,idx+1,1,count,dp);
    //     }
    //     return dp[idx][prev] = Math.max(Math.max(a,b),Math.max(c,d));
    // }
}