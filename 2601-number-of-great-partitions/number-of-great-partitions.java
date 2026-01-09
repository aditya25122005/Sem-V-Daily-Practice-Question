class Solution {
    public int countPartitions(int[] nums, int k) {
        int n=nums.length;
        long total=1;
        for(int i=0;i<nums.length;i++){
            total=((long)total*2)%1000000007;
        }
        long totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum<2*k) return 0;
        // Count Subsets with sum<k
        long[][] dp= new long[n][k];
        for(long []A:dp){
            Arrays.fill(A,-1);
        }

        long notValid=Solve(nums,0,0,k,dp);
        long valid=total-(notValid*2 %1000000007);
        if(valid<0){
            valid+=1000000007;
        }
        return (int)(valid);
    }
    public static long Solve(int[]nums, int idx,int curr, int k, long[][]dp){
        if(idx==nums.length){
            return 1;
        }

        if(dp[idx][curr]!=-1) return dp[idx][curr];
        // Skip
        long A= Solve(nums,idx+1,curr,k,dp);

        // take this in 1st(smaller subset)
        if(curr+nums[idx]<k){
            A=(A+ Solve(nums,idx+1,curr+nums[idx],k,dp))%1000000007;
        }
        return dp[idx][curr]=A;
    }
}