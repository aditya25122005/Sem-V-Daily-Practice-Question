class Solution {
    public long maximumProfit(int[] prices, int k) {
        long[][][] dp= new long[prices.length][3][k+1];
        for(long[][]D:dp){
            for(long[]A:D){
                Arrays.fill(A,-1);
            }
        }
       return Solve(prices,0,0,k,0,dp);
    }
    public static long Solve(int[] arr, int idx, int prev,int k,int curr, long[][][] dp){
        if(idx==arr.length ){
            if(prev==1 || prev==2){
                return Long.MIN_VALUE/2;// ab sell nhi kar sakte🫠
            }
            return 0;
        }
        if(curr==k){
            return 0;
        }
        if(dp[idx][prev][curr] !=-1) return dp[idx][prev][curr];

        long a=0;
        long b=0;
        long c=0;
        long d=0;
        long e=0;
        long f=0;
        long g=0;

        if(prev==0){
            if(idx<arr.length-1){
            a=-arr[idx]+Solve(arr,idx+1,1,k,curr,dp);
            }

            b=Solve(arr,idx+1,0,k,curr,dp);
            if(idx<arr.length-1){
            e=arr[idx]+Solve(arr,idx+1,2,k,curr,dp);
            }

        }
        if(prev==1){
            c=arr[idx]+Solve(arr,idx+1,0,k,curr+1,dp);
            d=Solve(arr,idx+1,1,k,curr,dp);
        }
        if(prev==2){
            f=-arr[idx]+Solve(arr,idx+1,0,k,curr+1,dp);
            g=Solve(arr,idx+1,2,k,curr,dp);
        }
        long ans=0;

        if(prev==0) ans= Math.max(a,Math.max(b,e));
        else if(prev==1) ans= Math.max(c,d);
        else ans = Math.max(f,g); 
        return dp[idx][prev][curr] = ans;
        

    }
}