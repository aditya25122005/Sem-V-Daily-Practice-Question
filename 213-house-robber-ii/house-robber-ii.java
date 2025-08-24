class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int [] dp1= new int[nums.length];
        int [] dp2= new int[nums.length];
        for(int i=0;i<dp1.length;i++){
            dp1[i]=-1;
            dp2[i]=-1;
        }
        int a=Robber(nums,1,nums.length-1,dp1); // not include first
        int b=Robber(nums, 0, nums.length-2, dp2); // not include last
        return Math.max(a,b);
        
    }
    public static int Robber(int[] nums,int i,int j,int[] dp){
        if(i>j){
            return 0;
        }
        if(dp[i] !=-1){
            return dp[i];
        }


        int rob= nums[i]+Robber(nums,i+2,j,dp);
        int norob=Robber(nums,i+1,j,dp);
        return dp[i]=Math.max(rob,norob);
    }
}