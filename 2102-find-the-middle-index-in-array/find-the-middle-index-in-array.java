class Solution {
    public int findMiddleIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int totalSum=0;
        for(int num:nums){
            totalSum+=num;
        }
        int curr=0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            // if(i!=0){
                if(totalSum-curr== curr-nums[i]){
                    return i;
                }
            // }
        }
        return -1;
    }
}