class Solution {
    public boolean isTrionic(int[] nums) {
        int i=1;
        while(i<nums.length && nums[i]>nums[i-1]){
            i++;
        }
        if(i==1) return false;
        int old=i;
        while(i<nums.length && nums[i]<nums[i-1]){
            i++;
        }
        if(i==old) return false;
        old=i;
        while(i<nums.length && nums[i]>nums[i-1]){
            i++;
        }
        if(i==old) return false;
        return i==nums.length? true: false;
    }
}