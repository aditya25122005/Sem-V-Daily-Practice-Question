class Solution {
    public int removeElement(int[] nums, int val) {
        int idx=0;
        int i=0;
        while(i<nums.length){
            if(nums[i]!=val) nums[idx++]=nums[i];
            i++;
        }
        return idx;
    }
}