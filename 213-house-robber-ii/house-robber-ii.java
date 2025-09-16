class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int [] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        int robOne=Robber(nums,0,dp);
        Arrays.fill(dp,-1);
        int robTwo=Robber2(nums,1,dp);
        return Math.max(robOne,robTwo);
    }
    public static int Robber(int[] nums, int idx,int[] dp){
        if(idx>=nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int rob=nums[idx]+Robber(nums,idx+2,dp);
        int norob=Robber(nums,idx+1,dp);
        return dp[idx]=Math.max(rob,norob);
    }
    public static int Robber2(int[] nums, int idx, int[] dp){
        if(idx>=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int rob=nums[idx]+Robber2(nums,idx+2,dp);
        int norob=Robber2(nums,idx+1,dp);
        return dp[idx]=Math.max(rob,norob);
    }
}