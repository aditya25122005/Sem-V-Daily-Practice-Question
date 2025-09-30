class Solution {
    public int maximumLength(int[] nums, int k) {
        Integer [] [] [] dp= new Integer[nums.length][k+1][nums.length+1];
        
        return Solve(nums,0,nums.length,k,0,dp);
    }
    public static int Solve(int[] nums, int idx, int prev, int k, int cnt, Integer[][][]dp){
        if(idx==nums.length){
            return 0;
        }
        if(dp[idx][cnt][prev] != null){
            return dp[idx][cnt][prev];
        }
        int skip = Solve(nums,idx+1,prev,k,cnt,dp);
        int noskip=0;

        if(prev==nums.length || nums[idx]==nums[prev]){
            noskip=1+Solve(nums,idx+1,idx,k,cnt,dp);
        }
        else if(cnt<k){
            noskip=1+Solve(nums,idx+1,idx,k,cnt+1,dp);
        }
        return dp[idx][cnt][prev]=Math.max(skip,noskip);
    }
}