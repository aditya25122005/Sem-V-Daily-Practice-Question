class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]<ans){
                ans = nums[mid];  
            }
            if(nums[mid]<nums[hi]){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;

    }
}