class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return Solve(nums,goal)-Solve(nums,goal-1);
        // count of subarray with sum less than or equal to goal - count
        // of subarray with sum less than or eq to goal-1
    }
    public static int Solve(int[] nums,int goal){
        int si=0;
        int ei=0;
        int curr=0;
        int ans=0;
        while(ei<nums.length){
            // grow
            curr+=nums[ei];
            // Shrink
            while(curr>goal && si<=ei){
                curr-=nums[si];
                si++;
            }
            // Update
            ans+= (ei-si+1);
            
            ei++;
        }

        return ans;
    }
}