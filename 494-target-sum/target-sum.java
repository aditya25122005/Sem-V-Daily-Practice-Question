class Solution {
    static int total;
    public int findTargetSumWays(int[] nums, int target) {
        total=0;
        for(int num: nums){
            total+= num;
        }
        Integer[][] dp= new Integer[nums.length][2*total +1];
        return Solve(nums,0,target,0,dp);
    }
    public static int Solve(int [] nums, int idx, int target, int curr,Integer[][] dp){
        
        if(idx>=nums.length){
            if(curr== target){
                return 1;
            }
            return 0;
        } 
        if(dp[idx][curr+total] != null) return dp[idx][curr+total];

        int A=0;
        int B=0;
        A= Solve(nums,idx+1,target,curr+nums[idx],dp);
        B= Solve(nums,idx+1,target,curr-nums[idx],dp);
        return dp[idx][curr+total] = A+B;

    }
}