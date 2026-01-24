class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int lo=0;
        int hi=nums.length-1;
        int ans=nums[lo]+nums[hi];
        while(lo<hi){
            ans=Math.max(ans,nums[lo]+nums[hi]);
            lo++;
            hi--;
        }
        return ans;
    }
}