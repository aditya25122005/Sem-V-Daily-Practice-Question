class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int si=0;
        int ei=0;
        int minLen=Integer.MAX_VALUE;

        int curr=0;

        while(ei<nums.length){
            curr+= nums[ei];

            while(curr>= target){
                minLen=Math.min(minLen,ei-si+1);
                curr-= nums[si];
                si++;
            }
            
            ei++;
        }
        if(curr>=target) minLen=Math.min(minLen,ei-si+1);
        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}