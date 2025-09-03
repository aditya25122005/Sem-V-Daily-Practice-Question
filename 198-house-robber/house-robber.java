class Solution {
    public int rob(int[] nums) {
        int [] dp= new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return solve(nums,0,nums.length-1,dp);

    }
    public static int solve(int[] nums, int i,int j, int[] dp){
        if(i>j){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int rob= nums[i]+solve(nums,i+2,j,dp);
        int norob=solve(nums,i+1,j,dp);
        return dp[i]=Math.max(rob,norob);
    }
}