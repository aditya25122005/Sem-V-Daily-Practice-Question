class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0;
        int ei=0;
        int ans=Integer.MAX_VALUE;
        int curr=0;
        while(ei<nums.length){
            curr+= nums[ei];
            
            while(curr>=target){
                ans=Math.min(ans,ei-si+1);
                curr-= nums[si];
                si++;
            }
            
            ei++;
        }
        return ans==Integer.MAX_VALUE? 0 : ans;
    }
}