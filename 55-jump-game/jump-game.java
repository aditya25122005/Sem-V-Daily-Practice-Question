class Solution {
    public boolean canJump(int[] nums) {
        Boolean [] dp= new Boolean[nums.length];
        int N = nums.length;
        int maxReach=0;
        int needed=1;
        dp[N-1] = true;
        for(int i=N-2;i>=0;i--){
            if(nums[i]>= needed){
                dp[i] = true;
                needed=1;
            }
            else{
                dp[i]=false;
                needed++;
            }
        }
        return dp[0]==true;

        // return Solve(nums,0, dp);
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