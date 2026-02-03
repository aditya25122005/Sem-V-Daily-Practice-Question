class Solution {
    public int maxCoins(int[] nums) {
        int n= nums.length;
        int [] arr= new int[n+2];
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
        }
        int [][] dp= new int[n+2][n+2];
        arr[0]=1;
        arr[n+1]=1;
        return Solve(arr,1,n,dp);

    }
    public static int Solve(int[] arr, int l, int r, int[][] dp){
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=0) return dp[l][r];
        int ans=0;
        for(int i=l;i<=r;i++){
            int A= arr[i]*arr[l-1]*arr[r+1]+Solve(arr,l,i-1,dp)+Solve(arr,i+1,r,dp);
            ans=Math.max(ans,A);
        }
        return dp[l][r] = ans;
    }
}