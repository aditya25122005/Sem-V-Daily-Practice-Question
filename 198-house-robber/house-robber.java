class Solution {
    public int rob(int[] nums) {
        int [] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return Robber(0,nums,dp);
    }
    public static int Robber(int idx,int[] nums, int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int rob= nums[idx]+Robber(idx+2,nums,dp);
        int norob= Robber(idx+1,nums,dp);
        return dp[idx]= Math.max(rob,norob);
    }
}