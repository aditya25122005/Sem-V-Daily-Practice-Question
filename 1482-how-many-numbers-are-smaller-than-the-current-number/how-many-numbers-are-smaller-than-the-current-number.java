class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] ans= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=count(nums,nums[i]);
        }
        return ans;
    }
    public static int count(int[] nums, int target){
        int cnt=0;
        for(int num:nums){
            if(num<target){
                cnt++;
            }
        }
        return cnt;
    }
}