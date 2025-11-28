class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;  //0
        for(int num:nums){
            total+=num; 
        }
        int max=nums[0];
        int curr=0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            max=Math.max(max,curr);
            if(curr<0){
                curr=0;
            }
        }
        curr=0;
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            curr+= nums[i];
            min=Math.min(min,curr);
            if(curr>0){
                curr=0;
            }
        }
        if(max<0){
            return max;
        }
        return Math.max(max,total-min);


    }
}