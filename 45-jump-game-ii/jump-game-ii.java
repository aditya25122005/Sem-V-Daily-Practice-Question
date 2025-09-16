class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        dp[n-1]=0;
        return Solve(0,nums,dp);
        


    }
    public static int Solve(int idx, int[] nums, int[] dp){
        if(idx==nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int minJump=nums.length;
        for(int j=1;j<=nums[idx] && idx+j<nums.length;j++){
            minJump=Math.min(minJump,1+Solve(idx+j,nums,dp));
        }
        return dp[idx]=minJump;
    }
}