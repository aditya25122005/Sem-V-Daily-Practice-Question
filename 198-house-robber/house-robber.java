class Solution {
    public int rob(int[] nums) {
        int[] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return Solve(nums, 0,dp);
    }
    public static int Solve(int[]nums,int idx, int[]dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int rob=nums[idx]+Solve(nums,idx+2,dp);
        int norob=Solve(nums,idx+1,dp);

        int ans=Math.max(rob,norob);
        return dp[idx]=ans;
    }
}