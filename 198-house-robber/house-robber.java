class Solution {
    public int rob(int[] nums) {
        int[] dp= new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
       return Robber(nums, 0,dp);
        
    }
    public static int Robber(int [] nums, int i,int [] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i] !=-1){
            return dp[i];
        }
        int rob=nums[i]+Robber(nums,i+2,dp);
        int norob=Robber(nums, i+1, dp);

        return dp[i]=Math.max(rob,norob);
    }
}