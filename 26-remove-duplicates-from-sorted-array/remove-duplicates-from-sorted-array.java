class Solution {
    public int removeDuplicates(int[] nums) {

        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]){

            }
            else{
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}