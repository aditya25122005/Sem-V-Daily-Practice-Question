class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       // Maximum sum of circular subarray = Total SUM- subarray with min Sum
       int total=0;
       int max=Integer.MIN_VALUE;
       int curr1=0;
       for(int num:nums){
        curr1+=num;
        max=Math.max(max,curr1);
        if(curr1<0){
            curr1=0;
        }
        total+=num;
       }

       int min=nums[0];
       int curr=0;
       for(int num:nums){
        curr+=num;
        min=Math.min(min,curr);
        
        if(curr>0){
            curr=0;
        }
        
       }
        if(max<0){
            return max;
        }
       return  Math.max(max,total-min);
    }
    


}