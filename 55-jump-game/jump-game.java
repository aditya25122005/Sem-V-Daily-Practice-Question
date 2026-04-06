class Solution {
    public boolean canJump(int[] nums) {
        Boolean [] dp= new Boolean[nums.length];

        return Solve(nums,0, dp);
    }
    public static boolean Solve(int [] nums, int idx, Boolean[] dp){
        if(idx==nums.length-1){
            return true;
        }

        if(idx>= nums.length){
            return false;
        }

        if(dp[idx] != null) return dp[idx];
        boolean ans =false;
        int step= nums[idx];
        for(int jump=1;jump<=step;jump++){
            ans = ans || Solve(nums,idx+jump,dp);
        }
        return dp[idx] = ans;
    }
}