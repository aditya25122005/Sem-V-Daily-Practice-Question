class Solution {
    static int total;
    public boolean canPartition(int[] nums) {
        total=0;
        for(int num: nums){
            total+= num;
        }
        System.out.println(total);
        if((total%2) ==1 ) return false;
        Boolean [][] dp= new Boolean[nums.length][total/2 +1];
        return Solve(nums,0,0,dp);
    }
    public static boolean Solve(int [] nums, int idx, int A,Boolean[][] dp){
        if(A== total/2) return true;
        if(A> total/2) return false;
        if(idx>=nums.length) return false;
        
        if(dp[idx][A] !=null) return dp[idx][A];
        boolean first = Solve(nums, idx+1, A+nums[idx],dp);
        boolean second= Solve(nums,idx+1, A, dp);

        return dp[idx][A] = first || second;
    }
}