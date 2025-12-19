class Solution {
    public int removeDuplicates(int[] nums) {
        int idx=0;
        int prev=0;
        int curr=1;
        for(int i=1;i<nums.length;i++){
            
            if(nums[i]==nums[prev]){
                curr++;
            }
            else{
                int val=nums[prev];
                prev=i;
                if(curr>=2){
                    nums[idx++]=val;
                    nums[idx++]=val;
                }
                else{
                    nums[idx++]=val;
                }
                curr=1;

            }
        }
        if(nums.length>=2 && nums[nums.length-1]==nums[nums.length-2]){
            nums[idx++]=nums[prev];
            nums[idx++]=nums[prev];
        }
        else{
            nums[idx++]=nums[nums.length-1];
        }
        return idx;
    }
}