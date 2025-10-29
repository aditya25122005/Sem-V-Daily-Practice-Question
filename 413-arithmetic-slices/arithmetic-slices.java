class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3) return 0;
        int si=0;
        int ei=2;
        int count=0;
        int ans=0;

        while(ei<nums.length){
            if(nums[ei]-nums[ei-1] == nums[ei-1]-nums[ei-2]){
                count++;
                ans+=count;
            }
            else{
                count=0;
            }
            ei++;
        }
        return ans;
        
    }
}