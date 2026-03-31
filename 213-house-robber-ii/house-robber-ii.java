class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int n= nums.length;
        Integer[][] dp= new Integer[n][n];
        return Math.max(Solve(nums,0,nums.length-2,dp), Solve(nums,1,nums.length-1,dp));
    }
    public static int Solve(int[] nums, int idx, int j,Integer[][] dp){
        if(idx>j){
            return 0;
        }
        if(dp[idx][j]!= null) return dp[idx][j];
        int A= nums[idx]+ Solve(nums,idx+2,j,dp);
        int B= Solve(nums,idx+1,j,dp);

        return dp[idx][j] = Math.max(A,B);
    }


    
}