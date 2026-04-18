class Solution {
    public boolean canPartition(int[] nums) {
        int n= nums.length;
       
        int total = 0;
        for(int num: nums){
            total+= num;
        }
        if(total%2==1){
            return false;
        }
         Boolean [][] dp= new Boolean[nums.length][total/2+1];
        return Solve(nums,0,total/2,dp);
    }
    public static boolean Solve(int [] nums, int idx, int target,Boolean[][] dp){
        if(target==0){
            return true;
        }
        if(idx>=nums.length){
            return false;
        }
        if(dp[idx][target] !=null) return dp[idx][target];
        boolean A=false;
        boolean B=false;
        if(target>=nums[idx]){
            A = Solve(nums,idx+1,target-nums[idx],dp);
        }
        B = Solve(nums,idx+1,target,dp);

        return dp[idx][target] = A || B;

    }
}