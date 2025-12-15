class Solution {
    public long getDescentPeriods(int[] prices) {
        long [] dp= new long[prices.length];
        Arrays.fill(dp,-1);
        long ans=0;
        for(int i=0;i<prices.length;i++){
            ans+= Solve(prices,i,dp);
        }
        return ans;
    }
    public static long Solve(int[] arr, int idx, long[]dp){

        long a=1;
        if(dp[idx]!=-1) return dp[idx];
    
        if(idx<arr.length-1 && arr[idx]==arr[idx+1]+1){
            a+=(Solve(arr,idx+1,dp));
        }

        return dp[idx]=a;

    }
}