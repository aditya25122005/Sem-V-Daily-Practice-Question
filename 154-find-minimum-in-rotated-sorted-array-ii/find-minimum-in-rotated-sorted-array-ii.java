class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int lo=0;
        int hi = nums.length-1;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            
            if(nums[hi]<nums[mid]){
                lo=mid+1;
            }
            else if(nums[mid]<nums[hi]){
                hi=mid;
            }
            else{
                hi--;
            }
        }
        return nums[lo];
    }
}