class Solution {
    public int maximumJumps(int[] nums, int target) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int res =  Solve(nums,0,target,dp);
        return res==Integer.MIN_VALUE? -1 : res;
    }
    public static int Solve(int [] nums, int idx, int target, int[] dp){
        if(idx>=nums.length){
            return Integer.MIN_VALUE;
        }
        if(idx==nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1) return dp[idx];
        int ans = Integer.MIN_VALUE;
        for(int j=idx+1;j<nums.length;j++){
            if(nums[j]-nums[idx]<=target && nums[j]-nums[idx]>=-target){
                int next = Solve(nums,j,target,dp);
                if(next!=Integer.MIN_VALUE){
                    ans=Math.max(ans,1+next);
                }
            }
        }
        return dp[idx] = ans;
    }
}