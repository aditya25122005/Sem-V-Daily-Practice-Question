class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp= new int[nums.length+1][3];
        for(int[]A:dp) Arrays.fill(A,-1);
        return Solve(nums,0,0,dp);
    }
    public static int Solve(int[] nums, int idx, int rem, int[][]dp){
        if(idx==nums.length){
            if(rem==0) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[idx][rem]!=-1) return dp[idx][rem];
        int a=nums[idx]+Solve(nums,idx+1,(rem+nums[idx])%3,dp);
        int b=Solve(nums,idx+1,rem,dp);
        return dp[idx][rem] = Math.max(a,b);
    }
}