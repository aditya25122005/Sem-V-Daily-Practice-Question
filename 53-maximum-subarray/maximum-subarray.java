class Solution {
    public int maxSubArray(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int curr=0;
        for(int num:nums){
            curr+=num;
            ans=Math.max(ans,curr);
            if(curr<0){
                curr=0;
            }
        }
        return ans;

    }
}