class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        
        return count(nums,right)-count(nums,left-1);
    }
    public int count(int[] nums, int bound){
        int curr=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=bound){
                curr++;
            }
            else{
                curr=0;
            }
            count+=curr;
        }
        return count;
    }
}