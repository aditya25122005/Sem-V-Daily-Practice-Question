class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                nums[idx]=nums[i];
                idx++;
            }
        }
        nums[idx]=nums[nums.length-1];
        idx++;

        return idx;
    }
}